package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Bean;
import by.it.advertproject.connectionpool.ConnectionPool;
import by.it.advertproject.dao.BaseDao;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static by.it.advertproject.constantmessage.Message.INTERNAL_ERROR;

public abstract class BaseDaoImpl<T extends Bean> implements BaseDao<T> {
    private static final Logger logger = LogManager.getLogger(BaseDao.class);

    protected void delete(Bean bean, String sqlRequest) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setLong(1, bean.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                // TODO: 19.10.2019 ??????
                //////////
                logger.log(Level.ERROR, INTERNAL_ERROR, e.getMessage());
            }
        }
    }

    protected List<T> findAllEntities(String sqlSelect, String table) throws DaoException {
        List<T> beans = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            BeanCreator<Bean> beanCreator = new BeanCreator<>();
            while (resultSet.next()) {
                T bean = (T) beanCreator.create(table, resultSet);
                beans.add(bean);
            }
        } catch (SQLException e) {
            throw new DaoException(INTERNAL_ERROR + e.getMessage(), e);
        } finally {
            closeResources(statement, connection);
        }
        return beans;
    }

    protected List<T> findBy(String sqlSelect, String table, String... value) throws DaoException {
        List<T> beans = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            preparedStatement = connection.prepareStatement(sqlSelect);
            for (int i = 0; i < value.length; i++) {
                preparedStatement.setString(i + 1, value[i]);
            }
            resultSet = preparedStatement.executeQuery();
            BeanCreator<T> beanCreator = new BeanCreator<>();
            while (resultSet.next()) {
                T bean = beanCreator.create(table, resultSet);
                beans.add(bean);
            }
        } catch (SQLException e) {
            throw new DaoException(INTERNAL_ERROR + e.getMessage(), e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                logger.log(Level.ERROR, INTERNAL_ERROR, e.getMessage());
            }
        }
        return beans;
    }

    protected void closeResources(Statement statement, Connection connection, ResultSet resultSet) {
        try {
            if (!(resultSet == null) || resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "ResultSet isn't closed.");
        }
        try {
            if (!(statement == null || statement.isClosed())) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Statement isn't closed.");
        }
        try {
            if (!(connection == null || connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "connection isn't return to the pool.");
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    protected void closeResources(Statement statement, Connection connection)
            throws DaoException {
        try {
            if (statement == null) {
                throw new DaoException(INTERNAL_ERROR);
            }
            statement.close();
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new DaoException(INTERNAL_ERROR);
        }
    }

    protected void closeResources(Statement statement) throws DaoException {
        try {
            if (statement == null) {
                throw new DaoException(INTERNAL_ERROR);
            }
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new DaoException(INTERNAL_ERROR);
        }
    }

    protected void closeResources(Statement statement, ResultSet resultSet)
            throws DaoException {
        try {
            if (resultSet == null) {
                throw new DaoException(INTERNAL_ERROR);
            }
            resultSet.close();
            if (statement == null) {
                throw new DaoException(INTERNAL_ERROR);
            }
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new DaoException(INTERNAL_ERROR);
        }
    }
}
