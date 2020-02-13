package by.it.advertproject.dao;

import by.it.advertproject.bean.Bean;
import by.it.advertproject.exception.DaoException;

import java.util.List;

/**
 * @param <T> - This describes my type parameter that extends {@link Bean}
 *            Interface define CRUD operations for working with database.
 */
public interface BaseDao<T extends Bean> {
    /**
     * @return List of found objects
     * @throws DaoException
     */
    List<T> findAll() throws DaoException;

    /**
     * @param index - pk of record in database
     * @return found object
     * @throws DaoException
     */
    T findBeanById(long index) throws DaoException;

    /**
     * @param t - deleted object
     * @throws DaoException
     */
    void delete(T t) throws DaoException;

    /**
     * @param t - created object
     * @return created object with id
     * @throws DaoException
     */
    T create(T t) throws DaoException;

    /**
     * @param t - updated object
     * @throws DaoException
     */
    void update(T t) throws DaoException;
}
