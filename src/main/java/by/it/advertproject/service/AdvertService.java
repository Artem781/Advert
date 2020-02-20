package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface AdvertService {
    Advert createAdvert(Map<String, String> carAdParameterMap, Long accountId) throws ServiceException;

    List<Advert> findAdvertBelongAccount(Account account) throws DaoException;

    List<Advert> findAllAdvert() throws DaoException;
}
