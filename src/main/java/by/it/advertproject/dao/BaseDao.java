package by.it.advertproject.dao;

import by.it.advertproject.bean.Bean;
import by.it.advertproject.exception.DaoException;

import java.util.List;

//public interface BaseDao<K, T extends Bean> {


public interface BaseDao<T extends Bean> {
    List<T> findAll() throws DaoException;

    T findBeanById(long index) throws DaoException;

    void delete(T t) throws DaoException;

    T create(T t) throws DaoException;

    void update(T t) throws DaoException;


//    List<T> findAll()throws DaoException;
//    T findBeanById(K id)throws DaoException;
//    boolean delete(T t)throws DaoException;
//    boolean delete(K id)throws DaoException;
//    boolean create(T t)throws DaoException;
//    T update(T t)throws DaoException;

//    default void close(Statement statement) {
//        try {
//            if (statement != null) {
//                statement.close();
//            }
//        } catch (SQLException e) {
//            //log
//        }
//    }
}
