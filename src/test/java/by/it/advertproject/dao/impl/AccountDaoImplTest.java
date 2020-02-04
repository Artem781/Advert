package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImplTest {
    private Account account;

    @BeforeClass
    public void setUp() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
        byte [] testNullArr = null;
        account = new Account.Builder()
                .withName("TestName")
                .withLogin("TestLogin")
                .withPassword("TestPsw")
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
        Account actual = accountDao.findAccountByLogin("TestLogin");
        Assert.assertEquals(actual, account);
    }

    @Test
    public void testFindById() throws DaoException {
        AccountDao accountDao = new AccountDaoImpl();
//        Account actual = ((AccountDaoImpl) accountDao).findById(account.getId());
//        Account actual = ((AccountDaoImpl) accountDao).findBeanById(account.getId());
        Account actual = accountDao.findBeanById(account.getId());
        Assert.assertEquals(actual, account);
    }
}
