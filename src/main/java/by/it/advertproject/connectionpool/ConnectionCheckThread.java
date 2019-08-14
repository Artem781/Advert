package by.it.advertproject.connectionpool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCheckThread extends Thread {
    private static Logger logger = LogManager.getLogger(ConnectionCheckThread.class);
    private final static String RUN_CHECK_THREAD_MESSAGE = "START CHECK CONNECTIONS THREAD.";
    private final static String ADD_CONN_MESSAGE = "ADD CONNECTION. SIZE OF FREE CONNECTIONS:";

    @Override
    public void run() {
        ConnectionPool connectionPool = ConnectionPool.INSTANCE;
        try {
            logger.log(Level.INFO, RUN_CHECK_THREAD_MESSAGE);
            while (connectionPool.getPoolSize() > connectionPool.getFreeConnectionBlockingQueue().size()
                    + connectionPool.getGivenAwayConnectionQueue().size()) {
                connectionPool.getFreeConnectionBlockingQueue()
                        .add(DriverManager.getConnection(connectionPool.getUrl(),
                                connectionPool.getUser(),
                                connectionPool.getPassword()));
                logger.log(Level.INFO, ADD_CONN_MESSAGE +
                        connectionPool.getFreeConnectionBlockingQueue().size());
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
