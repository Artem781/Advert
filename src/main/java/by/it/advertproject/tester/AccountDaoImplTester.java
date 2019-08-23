package by.it.advertproject.tester;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;

public class AccountDaoImplTester {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDaoImpl();
        Account account = new Account.Builder().withName("tomcat").withLogin("tomcat")
                .withPassword("tomcat").withBirthday("tomcat").withEmail("tomcat")
                .withTel("tomcat").withRole(Role.USER).build();
        try {
            Account account1 = accountDao.create(account);
        } catch (DaoException e) {
            System.out.println("from catch: " );
        }


    }
}