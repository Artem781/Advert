package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.util.MessageManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Pattern;

import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;
import static by.it.advertproject.command.impl.SetLanguageCommand.ENGLISH;

// TODO: 16.09.2019 как перенести страницы jsp в папку веб инф.
public class AccountService {
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    public Account checkLogin(String login, String password) throws ServiceException {
    String encryptedPassword = DigestUtils.md5Hex(password);
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account account;
        try {
            account = accountDao.findAccountByLogin(login);
            if (account == null) {
//                throw new ServiceException(MESSAGE_LOGIN_ERROR);
                throw new ServiceException(MESSAGE_ERROR_LOGIN_PASSWORD);
            }
            if (!account.getPassword().equals(encryptedPassword)) {
                logger.log(Level.WARN, account.getPassword() + " " + encryptedPassword);
//                throw new ServiceException(MESSAGE_PASSWORD_ERROR);
                throw new ServiceException(MESSAGE_ERROR_LOGIN_PASSWORD);
            }
        } catch (DaoException e) {
            throw new ServiceException(CAN_NOT_LOGIN);
        }
        return account;

    }

    public static Account findAccount(String login) throws ServiceException {
        AccountDao accountDao = new AccountDaoImpl();
        Account account = null;
        try {
            account = accountDao.findAccountByLogin(login);
            if (account == null) {
                throw new ServiceException(ACCOUNT_IS_NULL);
            }
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return account;
    }

    public static Account findAccount(long id) throws ServiceException {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account account;
        try {
            account = accountDao.findBeanById(id);
            if (account == null) {
                throw new ServiceException(ACCOUNT_IS_NULL);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return account;
    }


// TODO: 16.09.2019 проверяться уникальность логина только в базе данных как поле unique
    public Account createAccount(Map<String, String> parameterMap) throws ServiceException {
        logger.log(Level.INFO, "from AccountService) createAccount method.");
        SignUpParameterValidationState signUpParameterValidationState
                = SignUpParameterValidator.validateParameter(parameterMap);
        logger.log(Level.INFO, "from AccountService) createAccount method. after SignUpParameterValidator ");
        String encryptedPassword = DigestUtils.md5Hex(parameterMap.get(PARAM_PASSWORD));
        AccountDao accountDao = new AccountDaoImpl();
        Account account = new Account.Builder()
                .withName(parameterMap.get(PARAM_NAME))
                .withLogin(parameterMap.get(PARAM_NAME_LOGIN))
                .withPassword(encryptedPassword)
                .withBirthday(parameterMap.get(PARAM_BIRTHDAY))
                .withEmail(parameterMap.get(PARAM_EMAIL))
                .withTel(parameterMap.get(PARAM_TEL))
                .withRole(Role.USER).build();
        logger.log(Level.INFO, "from AccountService) createAccount method. create account with Builder");
        if (signUpParameterValidationState == SignUpParameterValidationState.VALID) {
            try {
                logger.log(Level.INFO, "from AccountService) createAccount method. try block");
                accountDao.create(account);
                logger.log(Level.INFO, "from AccountService) createAccount method. accountDao.create(account)");
                account = accountDao.findAccountByLogin(account.getLogin());
                logger.log(Level.INFO, "from AccountService) createAccount method. accountDao.findAccountByLogin(account.getLogin())");
            } catch (DaoException e) {
                logger.log(Level.INFO, "from AccountService) createAccount method. throw new ServiceException(BUSY_LOGIN_MESSAGE)");
                throw new ServiceException(BUSY_LOGIN_MESSAGE);
            }
        }
        return account;
    }

    private static class SignUpParameterValidator {
        private static final String ENGLISH_LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
        private static final String RUSSIAN_LOGIN_PATTERN = "([А-Я][а-я]{2,15})\\s([А-Я][а-я]{2,15})";
        private static final String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";
        private static final String PASSWORD_CONFIRM_PATTERN = "^[a-z0-9_-]{6,18}$";
        private static final String NAME_REGEX = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
        private static final String DATE_BIRTHDAY_REGEX = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        private static final String TEL_REGEX = "^(\\+)?([ 0-9]){10,16}$";
        private static final String PASSWORD_EQUALS_CONFIRM_PASSWORD = "passEqualsConfirmPass";


        public static SignUpParameterValidationState validateParameter(Map<String, String> parameterMap) throws ServiceException {
            SignUpParameterValidationState signUpParameterValidationState = SignUpParameterValidationState.VALID;
            logger.log(Level.INFO, "from AccountService) SignUpParameterValidator) validateParameter method.");
            Map<String, String> regexMap = new HashMap<>();
            regexMap.put(PARAM_NAME, NAME_REGEX);
            regexMap.put(PARAM_NAME_LOGIN, ENGLISH_LOGIN_PATTERN);
            regexMap.put(PARAM_PASSWORD, PASSWORD_PATTERN);
            regexMap.put(PARAM_PASSWORD_CONFIRM, PASSWORD_CONFIRM_PATTERN);
            regexMap.put(PARAM_BIRTHDAY, DATE_BIRTHDAY_REGEX);
            regexMap.put(PARAM_EMAIL, EMAIL_REGEX);
            regexMap.put(PARAM_TEL, TEL_REGEX);

            Map<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put(PARAM_NAME, NAME_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_NAME_LOGIN, LOGIN_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_PASSWORD, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_PASSWORD_CONFIRM, PASSWORD_CONFIRM_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_BIRTHDAY, BIRTHDAY_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_EMAIL, EMAIL_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PARAM_TEL, TEL_INCORRECT_FORMAT_MESSAGE);
            errorMessageMap.put(PASSWORD_EQUALS_CONFIRM_PASSWORD, NON_CONFIRM_PASSWORD_MESSAGE);
            logger.log(Level.INFO, "errorMessageMap size: " + errorMessageMap.size());
            logger.log(Level.INFO, "regexMap size: " + regexMap.size());
            logger.log(Level.INFO, "parameterMap size: " + parameterMap.size());
            StringBuilder errorMessageSb = new StringBuilder();
            for (Map.Entry<String, String> element : parameterMap.entrySet()) {
                if (!Pattern.matches(regexMap.get(element.getKey()), element.getValue())) {
                    errorMessageSb.append(errorMessageMap.get(element.getKey()) + "\t");
                }
            }
            if (!parameterMap.get(PARAM_PASSWORD).equals(parameterMap.get(PARAM_PASSWORD_CONFIRM))) {
                errorMessageSb.append(errorMessageMap.get(PASSWORD_EQUALS_CONFIRM_PASSWORD));
            }
            if (errorMessageSb.length() != 0) {
                logger.log(Level.INFO, "errorMessageSb !== null. errorMessageSb: " + errorMessageSb);
                throw new ServiceException(String.valueOf(errorMessageSb));
            }
            logger.log(Level.INFO, "from AccountService) SignUpParameterValidator) validateParameter method. " +
                    "return signUpParameterValidationState: " + signUpParameterValidationState.name());
            return signUpParameterValidationState;
        }
    }
}








// ======createAccount method
//
//        if (!Pattern.matches(NAME_REGEX, name)) {
//                throw new ServiceException("message. name not valid");
//                }
//                if (!Pattern.matches(LOGIN_PATTERN, login)) {
//                throw new ServiceException("message. login not valid");
//                }
//                if (!Pattern.matches(PASSWORD_PATTERN, password)) {
//                throw new ServiceException("message. password not valid");
//                }
//                if (!password.equals(passwordConfirm)) {
//                throw new ServiceException("message. password and password confirm not equals");
//                }
//                if (!Pattern.matches(DATE_BIRTHDAY_REGEX, birthday)) {
//                throw new ServiceException("message. birthday not valid");
//                }
//                if (!Pattern.matches(EMAIL_REGEX, email)) {
//                throw new ServiceException("message. e-mail not valid");
//                }
//                if (!Pattern.matches(TEL_REGEX, tel)) {
//                throw new ServiceException("message. tel not valid");
//                }
////        if (Pattern.matches(NAME_REGEX, name) ||
////                Pattern.matches(LOGIN_PATTERN, login) ||
////                Pattern.matches(PASSWORD_PATTERN, password) ||
////                Pattern.matches(DATE_BIRTHDAY_REGEX, birthday) ||
////                Pattern.matches(EMAIL_REGEX, email) ||
////                Pattern.matches(TEL_REGEX, tel)) {
////            System.out.println(name + Pattern.matches(NAME_REGEX, name) + "\n" +
////                    login + Pattern.matches(LOGIN_PATTERN, login) + "\n" +
////                    password + Pattern.matches(PASSWORD_PATTERN, password) + "\n" +
////                    birthday + Pattern.matches(DATE_BIRTHDAY_REGEX, birthday) + "\n" +
////                    email + Pattern.matches(EMAIL_REGEX, email) + "\n" +
////                    tel + Pattern.matches(TEL_REGEX, tel));
////            System.out.println("from AccountService) method createAccount) not valid data ");
////            throw new ServiceException("message. not valid data");
////        }
//                AccountDao accountDao = new AccountDaoImpl();
//                Account account = new Account.Builder().withName(name).withLogin(login)
//                .withPassword(password).withBirthday(birthday).withEmail(email)
//                .withTel(tel).withRole(role).build();
//                try {
//                accountDao.create(account);
//                account = accountDao.findAccountByLogin(account.getLogin());
//                } catch (DaoException e) {
//                throw new ServiceException("message busy login", e);
//                }
//                return account;