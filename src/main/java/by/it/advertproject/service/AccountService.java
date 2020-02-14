package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;

import java.util.List;
import java.util.Map;

// TODO: 14.02.2020 как генерировать описание интерфейса?
public interface AccountService {
    List<Account> findAllAccount() throws DaoException;

    Account checkLogin(String login, String password) throws ServiceException;

    Account findAccount(String login) throws ServiceException;

    Account findAccount(long id) throws ServiceException;

    void updatePhoto(long accountId, byte[] photo) throws ServiceException;

    Account createAccount(Map<String, String> parameterMap) throws ServiceException;

    void deleteAccount(long accountId) throws ServiceException;

    Account updateProfileData(long accountId, String name, String password, String confirm, String email, String tel) throws ServiceException;
}
