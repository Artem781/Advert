package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.service.AdvertService;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.*;
import static java.util.Locale.ENGLISH;

public class SignInCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getLogger(SignInCommand.class);

    public Router execute(RequestContent content) {
        LOGGER.log(Level.INFO, "SignInCommand");
        String page = null;
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        String pass = content.getRequestParameters(PARAM_NAME_PASSWORD, 0);
        TransmissionType transmissionType = TransmissionType.REDIRECT;
        Account account;
        AccountService accountService = new AccountService();
        AdvertService advertService = new AdvertService();
        try {
            account = accountService.checkLogin(login, pass);
            if (account.getRole().equals(Role.USER)) {
                List<Advert> userAdvertList = advertService.findAdvertBelongAccount(account);
                content.putSessionAttribute(ATTR_NAME_LIST_USER_ADVERT, userAdvertList);
                List<Advert> allAdvertList = advertService.findAllAdvert();
                content.putSessionAttribute(ATTR_NAME_LIST_ALL_ADVERT, allAdvertList);
                content.putSessionAttribute(ATTR_NAME_BIRTHDAY, account.getBirthday());
                content.putSessionAttribute(ATTR_NAME_EMAIL, account.getEmail());
                content.putSessionAttribute(ATTR_NAME_TELEPHONE, account.getTel());
                content.putSessionAttribute(ATTR_NAME_USER, account.getName());
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                page = CommandUrlBuilder.TO_USER_PROFILE_PAGE.setParams(
                        PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            } else if (account.getRole().equals(Role.ADMINISTRATOR)) {
                List<Account> allAccount = accountService.findAllAccount();
                content.putSessionAttribute(ATTR_NAME_ALL_ACCOUNT_LIST, allAccount);
                content.putRequestAttribute(ATTR_NAME_USER, account.getName());
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putRequestAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                content.putSessionAttribute(ATTR_NAME_BIRTHDAY, account.getBirthday());
                content.putSessionAttribute(ATTR_NAME_EMAIL, account.getEmail());
                content.putSessionAttribute(ATTR_NAME_TELEPHONE, account.getTel());
                page = CommandUrlBuilder.TO_ADMIN_PROFILE_PAGE.getUrl();
            }
        } catch (ServiceException e) {
            content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE,
                    MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
            page = CommandUrlBuilder.TO_SIGN_IN
                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage())
                    .getUrl();
            transmissionType = TransmissionType.REDIRECT;
        } catch (DaoException e) {
            page = CommandUrlBuilder.TO_SIGN_IN
                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage())
                    .getUrl();
        }
        return new Router(page, transmissionType);
    }
}