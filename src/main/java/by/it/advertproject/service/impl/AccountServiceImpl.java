package by.it.advertproject.service.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.dao.impl.AdvertDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.service.UserDataValidationState;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Pattern;

import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;

public class AccountServiceImpl implements AccountService {
    private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    AccountDao accountDao = new AccountDaoImpl();

    public List<Account> findAllAccount() throws DaoException {
        return accountDao.findAll();
    }

    public Account checkLogin(String login, String password) throws ServiceException {
        String encryptedPassword = DigestUtils.md5Hex(password);
        Account account;
        try {
            account = accountDao.findAccountByLogin(login);
            if (account == null) {
                throw new ServiceException(MESSAGE_ERROR_LOGIN_PASSWORD);
            }
            if (!account.getPassword().equals(encryptedPassword)) {
                logger.log(Level.WARN, account.getPassword() + " " + encryptedPassword);
                throw new ServiceException(MESSAGE_ERROR_LOGIN_PASSWORD);
            }
        } catch (DaoException e) {
            throw new ServiceException(CAN_NOT_LOGIN);
        }
        return account;
    }

    public Account findAccount(String login) throws ServiceException {
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

    public Account findAccount(long id) throws ServiceException {
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

    public void updatePhoto(long accountId, byte[] photo) throws ServiceException {
        try {
            Account account = accountDao.findBeanById(accountId);
            if (account == null) {
                throw new ServiceException(ACCOUNT_IS_NULL);
            }
            account.setPhoto(photo);
            accountDao.update(account);
        } catch (DaoException e) {
            throw new ServiceException(LOAD_FILE_ERROR_MESSAGE);
        }
    }

    public Account createAccount(Map<String, String> parameterMap) throws ServiceException {
        UserDataValidationState userDataValidationState
                = DataParameterValidator.validateParameter(parameterMap);
        String encryptedPassword = DigestUtils.md5Hex(parameterMap.get(PARAM_PASSWORD));
        Account account = new Account.Builder()
                .withName(parameterMap.get(PARAM_NAME))
                .withLogin(parameterMap.get(PARAM_NAME_LOGIN))
                .withPassword(encryptedPassword)
                .withBirthday(parameterMap.get(PARAM_BIRTHDAY))
                .withEmail(parameterMap.get(PARAM_EMAIL))
                .withTel(parameterMap.get(PARAM_TEL))
                .withRole(Role.USER).build();
        if (userDataValidationState == UserDataValidationState.VALID) {
            try {
                accountDao.create(account);
                account = accountDao.findAccountByLogin(account.getLogin());
            } catch (DaoException e) {
                throw new ServiceException(BUSY_LOGIN_MESSAGE);
            }
        }
        return account;
    }

    public void deleteAccount(long accountId) throws ServiceException {
        try {
            Account account = accountDao.findBeanById(accountId);
            if (account == null) {
                throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
            }
            AdvertDaoImpl advertDao = new AdvertDaoImpl();
            List<Advert> advertList = advertDao.findCountAdvertByAccountIdFk(accountId);
            if (advertList != null) {
                for (Advert element : advertList) {
                    advertDao.delete(element);
                }
            }
            accountDao.delete(account);
        } catch (DaoException e) {
            throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
        }
    }

    public Account updateProfileData(long accountId, String name, String password, String confirm, String email, String tel) throws ServiceException {
        UserDataValidationState userDataValidationState;
        Account account;
        if (password.equals(confirm)) {
            try {
                account = accountDao.findBeanById(accountId);
                if (account == null) {
                    throw new ServiceException(ACCOUNT_IS_NULL);
                }
            } catch (DaoException e) {
                throw new ServiceException(MESSAGE_LOGIN_ERROR);
            }
            userDataValidationState = DataParameterValidator
                    .validateParameter(name, password, tel, email);
            if (userDataValidationState == UserDataValidationState.VALID) {
                account.setName(name);
                String encryptedPassword = DigestUtils.md5Hex(password);
                account.setPassword(encryptedPassword);
                account.setEmail(email);
                account.setTel(tel);
                try {
                    accountDao.update(account);
                } catch (DaoException e) {
                    throw new ServiceException(BUSY_LOGIN_MESSAGE);
                }
            }
        } else {
            throw new ServiceException(NON_CONFIRM_PASSWORD_MESSAGE);
        }
        return account;
    }

    private static class DataParameterValidator {
        private static final String ENGLISH_LOGIN_PATTERN = "^[a-zA-Z0-9_-]{3,16}$";
        private static final String PASSWORD_PATTERN = "[a-zA-Zа-яА-Я0-9_ -]{6,12}";
        private static final String PASSWORD_CONFIRM_PATTERN = "[a-zA-Zа-яА-Я0-9_ -]{6,12}";
        private static final String NAME_REGEX = "[a-zA-Zа-яА-Я0-9_ ]{1,20}";
        private static final String DATE_BIRTHDAY_REGEX = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        private static final String TEL_REGEX = "[+][\\d]{5}[-][\\d]{7}";
        private static final String PASSWORD_EQUALS_CONFIRM_PASSWORD = "passEqualsConfirmPass";

        public static UserDataValidationState validateParameter(String name, String password, String tel, String email) throws ServiceException {
            UserDataValidationState validationState = UserDataValidationState.VALID;
            if (!(Pattern.matches(NAME_REGEX, name))) {
                throw new ServiceException(LOGIN_INCORRECT_FORMAT_MESSAGE);
            }
            if (!Pattern.matches(PASSWORD_PATTERN, password)) {
                throw new ServiceException(PASSWORD_INCORRECT_FORMAT_MESSAGE);
            }
            if (!Pattern.matches(EMAIL_REGEX, email)) {
                throw new ServiceException(EMAIL_INCORRECT_FORMAT_MESSAGE);
            }
            if (!Pattern.matches(TEL_REGEX, tel)) {
                throw new ServiceException(TEL_INCORRECT_FORMAT_MESSAGE);
            }
            return validationState;
        }

        public static UserDataValidationState validateParameter(Map<String, String> parameterMap) throws ServiceException {
            UserDataValidationState userDataValidationState = UserDataValidationState.VALID;
            logger.log(Level.INFO, "validateParameter");
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
            StringBuilder errorMessageSb = new StringBuilder();
            for (Map.Entry<String, String> element : parameterMap.entrySet()) {
                if (!Pattern.matches(regexMap.get(element.getKey()), element.getValue())) {
                    errorMessageSb.append(errorMessageMap.get(element.getKey())).append("\t");
                }
            }
            if (!parameterMap.get(PARAM_PASSWORD).equals(parameterMap.get(PARAM_PASSWORD_CONFIRM))) {
                errorMessageSb.append(errorMessageMap.get(PASSWORD_EQUALS_CONFIRM_PASSWORD));
            }
            if (errorMessageSb.length() != 0) {
                throw new ServiceException(String.valueOf(errorMessageSb));
            }
            return userDataValidationState;
        }
    }
}