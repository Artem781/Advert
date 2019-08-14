package by.it.advertproject.dao;

import by.it.advertproject.bean.Account;
import by.it.advertproject.exception.DaoException;

public interface AccountDao extends BaseDao<Account> {
    Account findAccountByLogin(String loginPattern) throws DaoException;
}
