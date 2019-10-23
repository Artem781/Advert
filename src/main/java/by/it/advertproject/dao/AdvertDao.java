package by.it.advertproject.dao;

import by.it.advertproject.bean.Advert;
import by.it.advertproject.exception.DaoException;

import java.util.List;

public interface AdvertDao extends BaseDao<Advert> {
    List<Advert> findAdvertByTitle(String patternTitle) throws DaoException;
    List<Advert> findCountAdvertByAccountIdFk(String patternTitle) throws DaoException;
}
