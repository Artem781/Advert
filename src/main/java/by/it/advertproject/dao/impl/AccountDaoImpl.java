package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.connectionpool.ConnectionPool;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

import static by.it.advertproject.constantmessage.Message.INTERNAL_ERROR;

public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
    private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);
    static final String TABLE_NAME = "accounts";

    //language=SQL
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "select idaccounts, name, login, password, birthday, email, tel, " +
                    "accesslevel from accounts";

    @Override
    public List<Account> findAll() throws DaoException {
        List<Account> accounts = super.findAllEntities(SQL_SELECT_ALL_ACCOUNTS, TABLE_NAME);
        return accounts;
    }

    //language=SQL
    private static final String SQL_SELECT_ACCOUNT_BY_ID =
            "select idaccounts, name, login, password, birthday, email, tel, accesslevel " +
                    "from accounts where idaccounts = ?";

    @Override
    public Account findBeanById(long index) throws DaoException {
        List<Account> accounts = super.findBy(SQL_SELECT_ACCOUNT_BY_ID, TABLE_NAME, String.valueOf(index));
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    //language=SQL
    private static final String SQL_SELECT_ACCOUNT_BY_LOGIN =
            "select idaccounts, name, login, password, birthday, email, tel, accesslevel " +
                    "from accounts where login = ?";

    @Override
    public Account findAccountByLogin(String loginPattern) throws DaoException {
        List<Account> accounts = findBy(SQL_SELECT_ACCOUNT_BY_LOGIN, TABLE_NAME, loginPattern);
        return accounts.isEmpty() ? null : accounts.get(0);
    }


    // вначало класса
    //language=SQL
    private static final String SQL_DELETE_ACCOUNT =
            "DELETE FROM accounts WHERE accounts.idaccounts = ?";

    @Override
    public void delete(Account account) throws DaoException {
        super.delete(account, SQL_DELETE_ACCOUNT);
    }

    //language=SQL
    private static final String SQL_CREATE_ACCOUNT = "INSERT INTO " +
            "accounts ( name, login, password, birthday, email, tel, accesslevel)" +
            " Values ( ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Account create(Account account) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            preparedStatement = connection.prepareStatement(
                    SQL_CREATE_ACCOUNT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getLogin());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getBirthday());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getTel());
            preparedStatement.setInt(7, account.getRole().ordinal());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                account.setId(generatedKeys.getLong(1));
            } else {
                throw new DaoException(INTERNAL_ERROR);
            }
            return account;
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new DaoException(INTERNAL_ERROR);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                logger.log(Level.ERROR, INTERNAL_ERROR, e.getMessage());
            }
        }
    }

    //language=SQL
    private static final String SQL_UPDATE_ACCOUNT = "UPDATE accounts SET accounts.name = ?," +
            " accounts.login = ?, accounts.password= ?," +
            " accounts.birthday = ?, accounts.email = ?," +
            " accounts.tel = ?, accounts.accesslevel = ? WHERE accounts.id = ?";

    @Override
    public void update(Account account) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ACCOUNT);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getLogin());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getBirthday());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getTel());
            preparedStatement.setInt(7, account.getRole().ordinal());
            preparedStatement.setLong(5, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new DaoException(INTERNAL_ERROR, e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                logger.log(Level.ERROR, INTERNAL_ERROR, e.getMessage());
            }
        }
    }
}
