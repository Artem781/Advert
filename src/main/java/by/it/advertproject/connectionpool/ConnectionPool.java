package by.it.advertproject.connectionpool;

import by.it.advertproject.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.*;

public enum ConnectionPool {
    INSTANCE;

    private final static Logger logger = LogManager.getRootLogger();
    private static final int DEFAULT_SIZE_POOL = 30;
    private static final int DEFAULT_HOURS_CHECK_DELAY = 24;
    private BlockingQueue<Connection> freeСonnectionBlockingQueue;
    private BlockingQueue<Connection> givenAwayConnectionQueue;
    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
    private final String DRIVER_NAME;
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private int poolSize;

     ConnectionPool() {
        DbResourceManager dbResourceManager = DbResourceManager.getInstance();
        this.DRIVER_NAME = dbResourceManager.getValue(DbParameter.DB_DRIVER);
        this.URL = dbResourceManager.getValue(DbParameter.DB_URL);
        this.USER = dbResourceManager.getValue(DbParameter.DB_USER);
        this.PASSWORD = dbResourceManager.getValue(DbParameter.DB_PASSWORD);
        try { poolSize = Integer.parseInt(
                dbResourceManager.getValue(DbParameter.DB_POOL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = DEFAULT_SIZE_POOL;
        }
        try {
            initPoolData();
        } catch (ConnectionPoolException e) {
            // что нужно писать в catch? как записать лог?
           // не ловить
            throw new RuntimeException("ijubhiubiugb",e);
        }
        startConnectionCheck();
    }

    private void initPoolData() throws ConnectionPoolException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            //в логах и эксепшенах в константы выносить не надо) без локализации
            logger.log(Level.ERROR, "driver registration error.", e.getMessage());
            // runtime exception
            throw new ConnectionPoolException(e);
        }
        freeСonnectionBlockingQueue = new LinkedBlockingDeque<>(poolSize);
        givenAwayConnectionQueue = new LinkedBlockingDeque<>();

        for (int i = 0; i < poolSize; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                freeСonnectionBlockingQueue.add(connection);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "can not take connection " +
                        "and add in freeСonnectionBlockingQueue.", e.getMessage());
                throw new ConnectionPoolException(e);
            }
        }
        //проверить сколько создалось конекшенов
    }

    public String getUrl() {
        return URL;
    }

    public String getUser() {
        return USER;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public int getPoolSize() {
        return poolSize;
    }

    BlockingQueue<Connection> getFreeConnectionBlockingQueue() {
        return freeСonnectionBlockingQueue;
    }

    BlockingQueue<Connection> getGivenAwayConnectionQueue() {
        return givenAwayConnectionQueue;
    }

    public void dispose() {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() {
        try {
            closeConnectionsQueue(givenAwayConnectionQueue);
            closeConnectionsQueue(freeСonnectionBlockingQueue);
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    public Connection takeConnection() {
        Connection connection = null;
        try {
            connection = freeСonnectionBlockingQueue.take();
            givenAwayConnectionQueue.offer(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.ERROR, "Error closing the connection.", e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!connection.isClosed() && givenAwayConnectionQueue.contains(connection)) {
                freeСonnectionBlockingQueue.put(connection);
                givenAwayConnectionQueue.take();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void startConnectionCheck() {
        Thread checkThread = new ConnectionCheckThread();
        executorService.scheduleAtFixedRate(checkThread, 0, DEFAULT_HOURS_CHECK_DELAY,
                TimeUnit.HOURS);
    }
    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            if (!(rs == null) || rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "ResultSet isn't closed.");
        }
        try {
            if (!(st == null || st.isClosed())) {
                st.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Statement isn't closed.");
        }
        try {
            if (!(con == null || con.isClosed())) {
                con.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "connection isn't return to the pool.");
        }
    }

    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            ((PooledConnection) connection).reallyClose();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < poolSize; i++) {
            try {
                PooledConnection pooledConnection =
                        new PooledConnection(freeСonnectionBlockingQueue.take());
                pooledConnection.reallyClose();
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "destroyPool isn't closed.");
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "deregisterDrivers isn't closed.");
        }
    }

    private class PooledConnection implements Connection {
        private Connection connection;

        PooledConnection(Connection c) {
            this.connection = c;
            try {
                this.connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            connection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }

        void reallyClose() {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, "connection isn't closed.");
            }
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public void close() throws SQLException {
            // проверка на null
            if (connection.isClosed()) {
                throw new SQLException("Attempting to close closed connection.");
            }
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            if (!givenAwayConnectionQueue.remove(this)) {
                throw new SQLException("Error deleting connection from the given away connections pool.");
            }
            if (!freeСonnectionBlockingQueue.offer(this)) {
                throw new SQLException("Error allocating connection in the pool");
            }
        }


        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            connection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            connection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            connection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            connection.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            connection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            connection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return connection.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            connection.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            connection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql, columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql, columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            connection.setClientInfo(name, value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            connection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return connection.createArrayOf(typeName, elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return connection.createStruct(typeName, attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            connection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            connection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            connection.setNetworkTimeout(executor, milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public void beginRequest() throws SQLException {
            connection.beginRequest();
        }

        @Override
        public void endRequest() throws SQLException {
            connection.endRequest();
        }

        @Override
        public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey, int timeout) throws SQLException {
            return connection.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
        }

        @Override
        public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
            return connection.setShardingKeyIfValid(shardingKey, timeout);
        }

        @Override
        public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey) throws SQLException {
            connection.setShardingKey(shardingKey, superShardingKey);
        }

        @Override
        public void setShardingKey(ShardingKey shardingKey) throws SQLException {
            connection.setShardingKey(shardingKey);
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }

    }


}
