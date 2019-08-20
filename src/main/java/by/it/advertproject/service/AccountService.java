package by.it.advertproject.service.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class AccountService {
    //todo в методах сервиса нужно возвращать булен или сам объект?
    private static final Logger logger = LogManager.getLogger(AccountService.class);
    private final static String LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
    private final static String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";

    public boolean checkLogin(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        //todo можно сократить эту запись?
        if ((validateLogin(login)) == false || (validatePassword(password)) == false) {
            return false;
        }
//        String encryptedPassword = DigestUtils.md5Hex(password);
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account account;
        try {
            account = accountDao.findAccountByLogin(login);
            if (account == null) {
                //todo бросать эксепшен или возвращать фолс?
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
            return false;
        }
        return true;
    }

    public boolean validateLogin(String login) {
        return (Pattern.matches(LOGIN_PATTERN, login)) ? true : false;
    }

    public boolean validatePassword(String password) {
        return (Pattern.matches(PASSWORD_PATTERN, password)) ? true : false;
    }

    public boolean validatePasswordAndLogin(String password, String login) {
        if (!(Pattern.matches(LOGIN_PATTERN, login))) {
            return false;
        }
        if (!Pattern.matches(PASSWORD_PATTERN, password)) {
            return false;
        }
        return true;
    }

    public Account createAccount(String name, String login, String psw, String pswConfirm,
                                 String birthday, String email, String tel, Role role) throws ServiceException {
        if (!psw.equals(pswConfirm)) {
            throw new ServiceException("message.non-confirm-password");
        }
        if (!(validatePasswordAndLogin(psw, login))) {
            throw new ServiceException("message.not valid password or login");
        }
        AccountDao accountDao = new AccountDaoImpl();
        Account account = new Account.Builder().withName(name).withLogin(login)
                .withPassword(psw).withBirthday(birthday).withEmail(email)
                .withTel(tel).withRole(role).build();


        try {
            accountDao.create(account);
            account = accountDao.findAccountByLogin(account.getLogin());
        } catch (DaoException e) {
            throw new ServiceException("message busy login");
        }

        return account;
    }


}
