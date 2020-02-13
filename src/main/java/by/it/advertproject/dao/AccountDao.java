package by.it.advertproject.dao;

import by.it.advertproject.bean.Account;
import by.it.advertproject.exception.DaoException;

/**
 * This interface extends {@link BaseDao} and parameterized him {@link Account}.
 * This interface define specific methods for working with accounts table.
 */
public interface AccountDao extends BaseDao<Account> {
    /**
     * @param loginPattern - login of account that need to find
     * @return found account
     * @throws DaoException
     */
    Account findAccountByLogin(String loginPattern) throws DaoException;
}
