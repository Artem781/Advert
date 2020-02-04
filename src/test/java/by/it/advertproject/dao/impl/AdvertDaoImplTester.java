package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.AdvertDao;
import by.it.advertproject.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdvertDaoImplTester {
    private Advert expectedAdvert;
    private Account account;
    private List<Advert> expected = new ArrayList<>();

    private static final Long LONG_NULL = null;
    private static final String ADVERT_TITLE = "TestTitle";
    private static final String ADVERT_DESCRIPTION = "TestDescription";
    private static final String ACCOUNT_NAME = "TestName";
    private static final String ACCOUNT_LOGIN = "TestLogin";
    private static final String ADVERT_BRAND = "TestLogin";
    private static final String ADVERT_MODEL = "TestLogin";
    private static final String ADVERT_COLOR = "TestLogin";
    private static final String ADVERT_BODY = "TestLogin";
    private static final int ADVERT_YEAR = 2000;
    private static final double ADVERT_VOLUME_ENGINE = 2.0;
    private static String ADVERT_AT = "mechanic";
    private static String ADVERT_DRIVEUNUT = "fwd";
    private static String ADVERT_EQUIPMENT = "eq";
    private static int ADVERT_MILEAGE = 10000;
    private static String ADVERT_CRASHED = "yes";

    @BeforeClass
    private void init() throws DaoException {
        AdvertDao advertDao = new AdvertDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();
        account = new Account.Builder()
                .withName(ACCOUNT_NAME)
                .withLogin(ACCOUNT_LOGIN)
                .withRole(Role.USER)
                .build();
        account = accountDao.create(account);
        BigDecimal bigDecimal = new BigDecimal(2222);
        Advert advert = new Advert.Builder()
                .withTitle(ADVERT_TITLE)
                .withDescription(ADVERT_DESCRIPTION)
                .withAccountIdFk(account.getId())
                .withBrand(ADVERT_BRAND)
                .withModel(ADVERT_MODEL)
                .withColor(ADVERT_COLOR)
                .withBody(ADVERT_BODY)
                .withYear(ADVERT_YEAR)
                .withEngine(ADVERT_VOLUME_ENGINE)
                .withAt(ADVERT_AT)
                .withDriveunit(ADVERT_DRIVEUNUT)
                .withEquipment(ADVERT_EQUIPMENT)
                .withMileage(ADVERT_MILEAGE)
                .withCrashed(ADVERT_CRASHED)
                .withPrice(bigDecimal)
                .build();
        this.expectedAdvert = advertDao.create(advert);
        expected.add(expectedAdvert);
    }

    @AfterClass
    private void destroy() throws DaoException {
        AdvertDao advertDao = new AdvertDaoImpl();
        AccountDaoImpl accountDao = new AccountDaoImpl();
        advertDao.delete(expectedAdvert);
        accountDao.delete(account);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testFindByTimeExpectedNull() throws DaoException {
        AdvertDao advertDao = new AdvertDaoImpl();
        Advert actual = advertDao.findBeanById(LONG_NULL);
        Assert.assertEquals(actual, expectedAdvert);
    }

    @Test
    public void testFindByTime() throws DaoException {
        AdvertDao advertDao = new AdvertDaoImpl();
        Advert actual = advertDao.findBeanById(expectedAdvert.getId());
        Assert.assertEquals(actual, expectedAdvert);
    }

    @Test
    public void findCountAdvertByAccountIdFk() throws DaoException {
        AdvertDao advertDao = new AdvertDaoImpl();
        List<Advert> actual = advertDao.findCountAdvertByAccountIdFk(account.getId());
        Assert.assertEquals(expected, actual);
    }
}
