package by.it.databasetask;

import by.it.advertproject.bean.Account;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;

import java.util.List;

public class TestDaoFinalPrj {
    public static void main(String[] args) {

        AccountDao accountDao = new AccountDaoImpl();

//        try {
//            List<Account> admin = ((AccountDaoImpl) accountDao).findAccountByLogin("admin");
//            System.out.println(admin.toString());
//        } catch (DaoException e) {
//            System.out.println("=================test");
//        }


    }

}
