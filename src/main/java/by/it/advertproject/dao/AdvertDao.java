package by.it.advertproject.dao;

import by.it.advertproject.bean.Advert;
import by.it.advertproject.exception.DaoException;

import java.util.List;

/**
 * This interface extends {@link BaseDao} and parameterized him {@link Advert}.
 * This interface define specific methods for working with adverts table.
 */
public interface AdvertDao extends BaseDao<Advert> {
    /**
     * @param patternTitle - ads matching the title.
     * @return List of found adverts
     * @throws DaoException
     */
    List<Advert> findAdvertByTitle(String patternTitle) throws DaoException;

    /**
     * @param patternIndex - count adverts by account that need to find
     * @return List of found adverts
     * @throws DaoException
     */
    List<Advert> findCountAdvertByAccountIdFk(long patternIndex) throws DaoException;
}
