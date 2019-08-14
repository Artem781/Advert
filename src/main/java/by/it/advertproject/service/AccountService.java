package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountService {
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    public boolean checkLogin(String login, String password) {
        if (login == null || password == null ){
            return false;
        }

//        String encryptedPassword = DigestUtils.md5Hex(password);
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account account;
        try {
//            account = accountDao.findByLogin(login);
            account = accountDao.findAccountByLogin(login);
            if (account == null) {
                return false;
//                throw new ServiceException(MESSAGE_LOGIN_ERROR);
            }
//            if (!account.getPassword().equals(encryptedPassword)) {
            if (!account.getPassword().equals(password)) {
//                logger.log(Level.WARN, account.getPassword() + " " + encryptedPassword);
                logger.log(Level.WARN, account.getPassword() + " " + password);
                return false;
//                throw new ServiceException(MESSAGE_PASSWORD_ERROR);
            }


        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
        }
        return true;
    }


}
