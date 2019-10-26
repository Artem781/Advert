package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.connectionpool.ConnectionPool;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.List;

import static by.it.advertproject.constantmessage.Message.INTERNAL_ERROR;

public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
    private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);
    static final String TABLE_NAME = "accounts";

    //language=SQL
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password," +
                    " anaron.account.birthday, anaron.account.email, anaron.account.tel, " +
                    "anaron.account.accesslevel from anaron.account";

    @Override
    public List<Account> findAll() throws DaoException {
        List<Account> accounts = super.findAllEntities(SQL_SELECT_ALL_ACCOUNTS, TABLE_NAME);
        return accounts;
    }

    //language=SQL
    private static final String SQL_SELECT_ACCOUNT_BY_ID =
            "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password," +
                    "anaron.account. birthday, anaron.account.email, anaron.account.tel, anaron.account.accesslevel, " +
                    "anaron.account.photo from anaron.account where anaron.account.idaccounts = ?";

    @Override
    public Account findBeanById(long index) throws DaoException {
        List<Account> accounts = super.findBy(SQL_SELECT_ACCOUNT_BY_ID, TABLE_NAME, String.valueOf(index));
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    //language=SQL
    private static final String SQL_SELECT_ACCOUNT_BY_LOGIN =
            "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password, " +
                    "anaron.account.birthday, anaron.account.email, anaron.account.tel, anaron.account.accesslevel," +
                    "anaron.account.photo from account where anaron.account.login = ?";

    @Override
    public Account findAccountByLogin(String loginPattern) throws DaoException {
        List<Account> accounts = findBy(SQL_SELECT_ACCOUNT_BY_LOGIN, TABLE_NAME, loginPattern);
        return accounts.isEmpty() ? null : accounts.get(0);
    }


    // вначало класса
    //language=SQL
    private static final String SQL_DELETE_ACCOUNT =
            "DELETE FROM anaron.account WHERE anaron.account.idaccounts = ?";

    @Override
    public void delete(Account account) throws DaoException {
        super.delete(account, SQL_DELETE_ACCOUNT);
    }

    //language=SQL
    private static final String SQL_CREATE_ACCOUNT = "INSERT INTO " +
            "account ( name, login, password, birthday, email, tel, accesslevel, photo)" +
            " Values ( ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setBlob(8, new ByteArrayInputStream(account.getPhoto()));
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
    private static final String SQL_UPDATE_ACCOUNT = "UPDATE anaron.account SET anaron.account.name = ?," +
            " anaron.account.login = ?, anaron.account.password= ?," +
            " anaron.account.birthday = ?, anaron.account.email = ?," +
            " anaron.account.tel = ?, anaron.account.accesslevel = ?, anaron.account.photo = ? " +
            "WHERE anaron.account.idaccounts = ?";

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
            preparedStatement.setBlob(8, new ByteArrayInputStream(account.getPhoto()));
            preparedStatement.setLong(9, account.getId());
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
