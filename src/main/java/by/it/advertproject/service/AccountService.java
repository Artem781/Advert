package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.dao.impl.AdvertDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Pattern;

import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;

public class AccountService {
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    public Account checkLogin(String login, String password) throws ServiceException {
        logger.log(Level.INFO, "from AccountService. method checkLogin ");
        String encryptedPassword = DigestUtils.md5Hex(password);
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account account;
        try {
            logger.log(Level.INFO, "from AccountService. try block ");
            account = accountDao.findAccountByLogin(login);
            logger.log(Level.INFO, "from AccountService. account: ");
            if (account == null) {
                logger.log(Level.INFO, "from AccountService. try block (account == null) ");
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

    public Account findAccount(String login) throws ServiceException {
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

    public Account findAccount(long id) throws ServiceException {
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

    public void updatePhoto(long accountId, byte[] photo) throws ServiceException {
        logger.log(Level.INFO, "From AccountService. updatePhoto method. ");
        AccountDaoImpl accountDao = new AccountDaoImpl();
        try {
            logger.log(Level.INFO, "From AccountService. try block. ");
            Account account = accountDao.findBeanById(accountId);
            logger.log(Level.INFO, "From AccountService. account = " + account.toString());
            if (account == null) {
                logger.log(Level.INFO, "From AccountService. account == null ");
                throw new ServiceException(ACCOUNT_IS_NULL);
            }
            account.setPhoto(photo);
            logger.log(Level.INFO, "From AccountService. account.setPhoto(photo) ");
            accountDao.update(account);
            logger.log(Level.INFO, "From AccountService. try block. end line");
        } catch (DaoException e) {
            logger.log(Level.INFO, "From AccountService. catch block. ");
            throw new ServiceException(LOAD_FILE_ERROR_MESSAGE);
        }
    }


    // TODO: 16.09.2019 проверяться уникальность логина только в базе данных как поле unique
    public Account createAccount(Map<String, String> parameterMap) throws ServiceException {
        logger.log(Level.INFO, "from AccountService) createAccount method.");
        UserDataValidationState userDataValidationState
                = DataParameterValidator.validateParameter(parameterMap);
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
        if (userDataValidationState == UserDataValidationState.VALID) {
            try {
                logger.log(Level.INFO, "from AccountService) createAccount method. try block");
                accountDao.create(account);
                logger.log(Level.INFO, "from AccountService) createAccount method. accountDao.create(account)");
                logger.log(Level.INFO, "from AccountService) account.getLogin(): " + account.getLogin());
                account = accountDao.findAccountByLogin(account.getLogin());
                logger.log(Level.INFO, "from AccountService) createAccount method. accountDao.findAccountByLogin(account.getLogin())");
            } catch (DaoException e) {
                logger.log(Level.INFO, "from AccountService) createAccount method. throw new ServiceException(BUSY_LOGIN_MESSAGE)");
                throw new ServiceException(BUSY_LOGIN_MESSAGE);
            }
        }
        return account;
    }


    public void deleteAccount(long accountId) throws ServiceException {
        logger.log(Level.INFO, "from AccountService) deleteAccount method. ");
//        TransactionManager transactionManager = new TransactionManager();
        AccountDaoImpl accountDao = new AccountDaoImpl();
        try {
            logger.log(Level.INFO, "from AccountService) deleteAccount method. Account account = accountDao.findBeanById(accountId);");
            Account account = accountDao.findBeanById(accountId);
            logger.log(Level.INFO, "from AccountService) deleteAccount method. (account == null): " + (account == null));
            if (account == null) {
                logger.log(Level.INFO, "from AccountService) deleteAccount method. throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);");
                throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
            }
//            PostDaoImpl postDao = new PostDaoImpl();
//            CommentDaoImpl commentDao = new CommentDaoImpl();
//            TagDaoImpl tagDao = new TagDaoImpl();
            AdvertDaoImpl advertDao = new AdvertDaoImpl();
//            transactionManager.startTransaction(accountDao, postDao, commentDao, tagDao);
//            List<Post> posts = postDao.findByAccount(account);
            logger.log(Level.INFO, "from AccountService) deleteAccount method. List<Advert> advertList = advertDao.findCountAdvertByAccountIdFk(accountId)");
            List<Advert> advertList = advertDao.findCountAdvertByAccountIdFk(accountId);

            logger.log(Level.INFO, "from AccountService) deleteAccount method. (advertList == null): " + (advertList != null));
            if (advertList != null) {
                for (Advert element : advertList) {
                    logger.log(Level.INFO, "from AccountService) deleteAccount method. element: ");
                    advertDao.delete(element);
                }
            }
            logger.log(Level.INFO, "from AccountService) deleteAccount method. accountDao.delete(account); ");

//            for (Post post : posts) {
//                List<Comment> comments = commentDao.findByPost(post);
//                for (Comment comment : comments) {
//                    commentDao.delete(comment);
//                }
//                List<PicTag> tags = tagDao.findByPost(post);
//                for (PicTag tag : tags) {
//                    postDao.deleteTag(tag, post);
//                }
//                postDao.delete(post);
//            }
//
//            List<Account> subs = accountDao.findSubscriptionsByAccount(account);
//            for (Account sub : subs) {
//                accountDao.deleteSubscription(account, sub);
//            }
//            List<Account> subscribers = accountDao.findSubscriberByAccount(account);
//            for (Account subscriber : subscribers) {
//                accountDao.deleteSubscription(subscriber, account);
//            }
//            List<Post> likedPosts = postDao.findPostsByLiker(account);
//            for (Post post : likedPosts) {
//                accountDao.deleteLike(account, post);
//            }
//            List<Comment> comments = commentDao.findByAuthor(account);
//            for (Comment comment : comments) {
//                commentDao.delete(comment);
//            }
            accountDao.delete(account);
//            transactionManager.commit();
        } catch (DaoException e) {
//            try {
////                transactionManager.rollback();
//            } catch (DaoException e1) {
//                throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
//            }
            throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
        } finally {
//            try {
////                transactionManager.finishTransaction();
//            } catch (DaoException e) {
//                throw new ServiceException(CAN_NOT_DELETE_ACCOUNT);
//            }
        }

    }

    public Account updateProfileData(long accountId, String name, String password, String confirm, String email, String tel) throws ServiceException {
        logger.log(Level.INFO, "from AccountService. updateProfileData method. ");
        AccountDaoImpl accountDao = new AccountDaoImpl();
        UserDataValidationState userDataValidationState;
        Account account;
        if (password.equals(confirm)) {
            try {
                logger.log(Level.INFO, "from AccountService. updateProfileData method. try block ");
                account = accountDao.findBeanById(accountId);
                if (account == null) {
                    logger.log(Level.INFO, "from AccountService. updateProfileData method. try block (account == null) ");
                    throw new ServiceException(ACCOUNT_IS_NULL);
                }
                logger.log(Level.INFO, "from AccountService. updateProfileData method. before catch catch (DaoException e)");
            } catch (DaoException e) {
                logger.log(Level.INFO, "from AccountService. updateProfileData method. catch block ");
                throw new ServiceException(MESSAGE_LOGIN_ERROR);
            }
            account.setName(name);
            String encryptedPassword = DigestUtils.md5Hex(password);
            account.setPassword(encryptedPassword);
            userDataValidationState = DataParameterValidator
                    .validateParameter(name, password, tel, email);
            logger.log(Level.INFO, "from AccountService. updateProfileData method. (userDataValidationState == UserDataValidationState.VALID): "
                    + (userDataValidationState == UserDataValidationState.VALID));
            if (userDataValidationState == UserDataValidationState.VALID) {
                try {
                    logger.log(Level.INFO, "from AccountService. updateProfileData method. try block accountDao.update(account)");
                    accountDao.update(account);
                } catch (DaoException e) {
                    logger.log(Level.INFO, "from AccountService. updateProfileData method. catch (DaoException e)");
                    throw new ServiceException(BUSY_LOGIN_MESSAGE);
                }
            }
        } else {
            logger.log(Level.INFO, "from AccountService. updateProfileData method. } else {");
            throw new ServiceException(NON_CONFIRM_PASSWORD_MESSAGE);
        }
        logger.log(Level.INFO, "from AccountService. updateProfileData method.  return account");
        return account;
    }

    private static class DataParameterValidator {
        private static final String ENGLISH_LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
        private static final String RUSSIAN_LOGIN_PATTERN = "([А-Я][а-я]{2,15})\\s([А-Я][а-я]{2,15})";
        private static final String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";
        private static final String PASSWORD_CONFIRM_PATTERN = "^[a-z0-9_-]{6,18}$";
        private static final String NAME_REGEX = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
        private static final String DATE_BIRTHDAY_REGEX = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        private static final String TEL_REGEX = "^(\\+)?([ 0-9]){10,16}$";
        private static final String PASSWORD_EQUALS_CONFIRM_PASSWORD = "passEqualsConfirmPass";

        public static UserDataValidationState validateParameter(String name, String password, String tel, String email) throws ServiceException {
            logger.log(Level.INFO, "from AccountService) DataParameterValidator) validateParameter method.");
            UserDataValidationState validationState = UserDataValidationState.VALID;
            logger.log(Level.INFO, "from AccountService) DataParameterValidator) validateParameter method." +
                    " (!(Pattern.matches(NAME_REGEX, name): " + (!(Pattern.matches(NAME_REGEX, name))));
            if (!(Pattern.matches(NAME_REGEX, name)
//                    || Pattern.matches(RUSSIAN_LOGIN_PATTERN, login)
            )) {
                logger.log(Level.INFO, "throw new ServiceException(LOGIN_INCORRECT_FORMAT_MESSAGE);");
                throw new ServiceException(LOGIN_INCORRECT_FORMAT_MESSAGE);
            }
            logger.log(Level.INFO, "from AccountService) DataParameterValidator) validateParameter method." +
                    " (!Pattern.matches(PASSWORD_PATTERN, password)): " + (!Pattern.matches(PASSWORD_PATTERN, password)));
            if (!Pattern.matches(PASSWORD_PATTERN, password)) {
                logger.log(Level.INFO, "throw new ServiceException(PASSWORD_INCORRECT_FORMAT_MESSAGE);");
                throw new ServiceException(PASSWORD_INCORRECT_FORMAT_MESSAGE);
            }
            logger.log(Level.INFO, "from AccountService) DataParameterValidator) validateParameter method." +
                    " (!Pattern.matches(EMAIL_REGEX, email)): " + (!Pattern.matches(EMAIL_REGEX, email)));
            if (!Pattern.matches(EMAIL_REGEX, email)) {
                logger.log(Level.INFO, "throw new ServiceException(EMAIL_INCORRECT_FORMAT_MESSAGE);");
                throw new ServiceException(EMAIL_INCORRECT_FORMAT_MESSAGE);
            }
            logger.log(Level.INFO, "from AccountService) DataParameterValidator) validateParameter method." +
                    " (!Pattern.matches(TEL_REGEX, tel)): " + (!Pattern.matches(TEL_REGEX, tel)));
            if (!Pattern.matches(TEL_REGEX, tel)) {
                logger.log(Level.INFO, "throw new ServiceException(TEL_INCORRECT_FORMAT_MESSAGE);");
                throw new ServiceException(TEL_INCORRECT_FORMAT_MESSAGE);
            }
            logger.log(Level.INFO, "return validationState.name: " + validationState.name());
            return validationState;
        }

        public static UserDataValidationState validateParameter(Map<String, String> parameterMap) throws ServiceException {
            UserDataValidationState userDataValidationState = UserDataValidationState.VALID;
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
                    "return signUpParameterValidationState: " + userDataValidationState.name());
            return userDataValidationState;
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