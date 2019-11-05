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
            System.out.println("111111111111111111111111111111");
            connection = ConnectionPool.INSTANCE.takeConnection();
            System.out.println("2222222222222222222222222222222222");

            preparedStatement = connection.prepareStatement(sqlSelect);
            System.out.println("333333333333333333333333333333333");
            System.out.println("value.length: " + value.length);
            for (int i = 0; i < value.length; i++) {
                System.out.println("44444444444444444444444444444444");
                String s = value[i];
                System.out.println("value[i]: " + value[i]);
                System.out.println("i + 1 = " + (i+1));
                preparedStatement.setString(i + 1, value[i]);
                System.out.println("55555555555555555555555555555");

            }
            System.out.println("6666666666666666666666666");

            resultSet = preparedStatement.executeQuery();
            System.out.println("777777777777777777777777");

            BeanCreator<T> beanCreator = new BeanCreator<>();
            while (resultSet.next()) {
                System.out.println("888888888888888888888888888");

                T bean = beanCreator.create(table, resultSet);
                System.out.println("999999999999999");

                beans.add(bean);
                System.out.println("10 10 10 10 10 10");

            }
            System.out.println("11 11 11 11 11 11 11 11 11 11 11 11 11 1");

        } catch (SQLException e) {
            System.out.println(" 12 12 12 12 12 1 2");

            throw new DaoException(INTERNAL_ERROR + e.getMessage(), e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                System.out.println("13 13 13 13 13 13");

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
