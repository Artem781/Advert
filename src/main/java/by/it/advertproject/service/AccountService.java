package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class AccountService {
    private static final Logger logger = LogManager.getLogger(AccountService.class);
    private final static String LOGIN_PATTERN = "^[a-z0-9_-]{3,16}";
    private final static String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}";

    public boolean checkLogin(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        if (validateLogin(login)){

        }
        //todo можно сократить эту запись?
        if ((validateLogin(login))==false || (validatePassword(password))==false) {
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

    public boolean validateLogin(String login) {
        return (Pattern.matches(LOGIN_PATTERN, login)) ? true : false;
    }

    public boolean validatePassword(String password) {
        return (Pattern.matches(PASSWORD_PATTERN, password)) ? true : false;
    }


}
