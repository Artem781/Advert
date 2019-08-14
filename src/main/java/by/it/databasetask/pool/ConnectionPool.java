package by.it.databasetask.pool;//package project.java.pool;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayDeque;
//import java.util.Enumeration;
//import java.util.Properties;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class ConnectionPool {
//    private static Logger logger = LogManager.getLogger();
//    private static final int POOL_SIZE;
//    private static final Properties JDBC_PARAMETERS;
//    private static final String URL;
//    private static final AtomicInteger connectionsCurrentSize = new AtomicInteger(0);
//    private static final AtomicInteger badConnectionsCurrentSize = new AtomicInteger(0);
//    private static ConnectionPool instance;
//    private static ReentrantLock lock = new ReentrantLock();
//    private static AtomicBoolean isVolatile = new AtomicBoolean(false);
//    private  BlockingQueue<ProxyConnection> availableConnections;
//    private  ArrayDeque<ProxyConnection> usedConnections = new ArrayDeque<>();
//
//    static {
//        DatabaseProperty properties = new DatabaseProperty();
//        properties.setProperty();
//        JDBC_PARAMETERS = properties.getProperties();
//        POOL_SIZE = Integer.valueOf(JDBC_PARAMETERS.getProperty("poolSize"));
//        URL = JDBC_PARAMETERS.getProperty("url");
//    }
//
//    private ReadWriteLock poolLock = new ReentrantReadWriteLock();
//    private Lock writeLock = poolLock.writeLock();
//    private Lock readLock = poolLock.readLock();
//
//    private ConnectionPool() {
//        if (instance != null) {
//            throw new RuntimeException("ConnectionPool already exists!");
//        }
//        try {
//            init();
//        } catch (ConnectionPoolException e) {
//            logger.error("An error while creating connection to database ", e);
//        }
//    }
//
//    private  void init() throws ConnectionPoolException {
//        Connection connection;
//        ProxyConnection proxy;
//        availableConnections = new LinkedBlockingDeque<>(POOL_SIZE);
//        try {
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            logger.error("An error while initializing JDBC driver  ", e);
//            throw new ExceptionInInitializerError("An error while initializing JDBC driver");
//        }
//        for (int i = 0; i < POOL_SIZE; i++) {
//            try {
//                connection = DriverManager.getConnection(URL, JDBC_PARAMETERS);
//                proxy = new ProxyConnection(connection);
//                if (availableConnections.offer(proxy)) {
//                    connectionsCurrentSize.getAndIncrement();
//                } else {
//                    badConnectionsCurrentSize.getAndIncrement();
//                }
//            } catch (SQLException e) {
//                logger.error("An error while creating connection to database ", e);
//                throw new ConnectionPoolException(" connection pool exception",e);
//            }
//        }
//        checkBadConnectionCount();
//    }
//
//    public static ConnectionPool getInstance() {
//        if (!isVolatile.get()) {
//            lock.lock();
//            try {
//                if (instance == null) {
//                    instance = new ConnectionPool();
//                    isVolatile.set(true);
//                }
//            } finally {
//                lock.unlock();
//            }
//        }
//        return instance;
//    }
//
//    private static void checkBadConnectionCount() {
//        if (badConnectionsCurrentSize.intValue() == POOL_SIZE) {
//            logger.fatal("initialization error, application terminated");
//            throw new ExceptionInInitializerError("No one connection created");
//        }
//    }
//
//    public ProxyConnection getConnection() {
//        ProxyConnection con = null;
//        try {
//            con = availableConnections.take();
//            writeLock.lock();
//            usedConnections.offer(con);
//            writeLock.unlock();
//        } catch (InterruptedException e) {
//            logger.error("Can't take connection", e);
//            Thread.currentThread().interrupt();
//        }
//        return con;
//    }
//
//    public void releaseConnection(ProxyConnection connection) {
//        writeLock.lock();
//        try {
//            if (!usedConnections.remove(connection)) {
//                throw new IllegalArgumentException("Connection not controlled by this connection pool: "
//                        + connection);
//            }
//            if (availableConnections.offer(connection)) {
//                connectionsCurrentSize.getAndIncrement();
//            } else {
//                badConnectionsCurrentSize.getAndIncrement();
//            }
//            checkBadConnectionCount();
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        throw new CloneNotSupportedException();
//    }
//
//    void putConnection(ProxyConnection proxyConnection) {
//        try {
//            availableConnections.put(proxyConnection);
//        } catch (InterruptedException e) {
//            logger.error("Can't put connection", e);
//            Thread.currentThread().interrupt();
//        }
//    }
//
////    private void addConnection(ProxyConnection connection) {
////        poolLock.lock();
////        try {
////            availableConnections.add(connection);
////            available.signal();
////        } finally {
////            poolLock.unlock();
////        }
////    }
//
//    public void destroyConnections() throws ConnectionPoolException {
//        try {
//            for (int i = 0; i < POOL_SIZE; i++) {
//                ProxyConnection proxyConnection = availableConnections.take();
//                proxyConnection.closeConnection();
//            }
//            Enumeration<Driver> drivers = DriverManager.getDrivers();
//            while (drivers.hasMoreElements()) {
//                Driver driver = drivers.nextElement();
//                DriverManager.deregisterDriver(driver);
//                logger.info(String.format("deregistering jdbc driver: %s", driver));
//            }
//        } catch (SQLException e) {
//            logger.error("Error deregistering driver ", e);
//            throw new ConnectionPoolException(" connection pool exception",e);
//        } catch (InterruptedException e) {
//            logger.error("Error closing connection ", e);
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    //    private class PooledConnectionIdleTask extends TimerTask {
////        private ConnectionPool poolReference;
////
////        public PooledConnectionIdleTask(ConnectionPool connectionPool) {
////            poolReference = connectionPool;
////        }
////
////        public void run() {
////            poolReference.closeIdleTimeoutConnection();
////        }
////    }
//
//}
//
