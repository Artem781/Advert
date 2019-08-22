package by.it.advertproject.service;

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
    private final static String NAME_REGEX = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
//   ([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))
    private final static String DATE_BIRTHDAY_REGEX = "^(|(0[1-9])|(1[0-2]))\\/((0[1-9])|(1\\d)|(2\\d)|(3[0-1]))\\/((\\d{4}))$";
    private final static String EMAIL_REGEX = "^.+@[^\\.].*\\.[a-z]{2,}$";
    private final static String TEL_REGEX = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$";


    public boolean checkLoginPass(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        if (!(validateLogin(login))  || !(validatePassword(password)) ) {
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

    public Account createAccount(String name, String login, String password,
                                 String passwordConfirm, String birthday,
                                 String email, String tel, Role role) throws ServiceException {
        if (!password.equals(passwordConfirm)) {
            throw new ServiceException("message.non-confirm-password");
        }
        if (!(validatePasswordAndLogin(password, login))) {
            throw new ServiceException("message.not valid password or login");
        }
        if (Pattern.matches(NAME_REGEX, name) ||
                Pattern.matches(LOGIN_PATTERN, login) ||
                Pattern.matches(PASSWORD_PATTERN, password) ||
                Pattern.matches(DATE_BIRTHDAY_REGEX, birthday) ||
                Pattern.matches(EMAIL_REGEX, email) ||
                Pattern.matches(TEL_REGEX, tel)) {
            System.out.println("from AccountService) method createAccount) not valid data ");
            throw new ServiceException("message. not valid data");
        }
        AccountDao accountDao = new AccountDaoImpl();
        Account account = new Account.Builder().withName(name).withLogin(login)
                .withPassword(password).withBirthday(birthday).withEmail(email)
                .withTel(tel).withRole(role).build();
        try {
            accountDao.create(account);
            account = accountDao.findAccountByLogin(account.getLogin());
        } catch (DaoException e) {
            throw new ServiceException("message busy login", e);
        }
        return account;
    }
}
