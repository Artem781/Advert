package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountDaoImplTest {
    private Account account;
    private static final String ACCOUNT_NAME = "TestName";
    private static final String ACCOUNT_LOGIN = "TestLogin";

    @BeforeClass
    public void setUp() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
        account = new Account.Builder()
                .withName(ACCOUNT_NAME)
                .withLogin(ACCOUNT_LOGIN)
                .withRole(Role.USER)
                .build();
        account = accountDao.create(account);
    }

    @AfterClass
    public void tearDown() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }

    @Test
    public void testFindAccountByLogin() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
        Account actual = accountDao.findAccountByLogin(ACCOUNT_LOGIN);
        Assert.assertEquals(actual, account);
    }

    @Test
    public void testFindById() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
        Account actual = accountDao.findBeanById(account.getId());
        Assert.assertEquals(actual, account);
    }
}
