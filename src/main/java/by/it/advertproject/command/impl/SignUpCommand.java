package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.impl.AccountServiceImpl;
import by.it.advertproject.service.impl.AdvertServiceImpl;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;
import static java.util.Locale.ENGLISH;

public class SignUpCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getLogger(SignUpCommand.class);

    @Override
    public Router execute(RequestContent content) {
        LOGGER.log(Level.INFO, "SignUpCommand");
        String page;
        Map<String, String> parameterMap = new HashMap<>();
        String name = content.getRequestParameters(PARAM_NAME, 0);
        parameterMap.put(PARAM_NAME, name);
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        parameterMap.put(PARAM_NAME_LOGIN, login);
        String pass = content.getRequestParameters(PARAM_PASSWORD, 0);
        parameterMap.put(PARAM_PASSWORD, pass);
        String confirmPass = content.getRequestParameters(PARAM_PASSWORD_CONFIRM, 0);
        parameterMap.put(PARAM_PASSWORD_CONFIRM, confirmPass);
        String birthday = content.getRequestParameters(PARAM_BIRTHDAY, 0);
        parameterMap.put(PARAM_BIRTHDAY, birthday);
        String email = content.getRequestParameters(PARAM_EMAIL, 0);
        parameterMap.put(PARAM_EMAIL, email);
        String tel = content.getRequestParameters(PARAM_TEL, 0);
        parameterMap.put(PARAM_TEL, tel);
        content.putRequestAttribute(ATTR_NAME_LOGIN, login);
        content.putRequestAttribute(ATTR_NAME_BIRTHDAY, birthday);
        content.putRequestAttribute(ATTR_NAME_EMAIL, email);
        content.putRequestAttribute(ATTR_NAME_TELEPHONE, tel);
        content.putRequestAttribute(ATTR_NAME_ACCESS_LEVEL, Role.USER.name());
        TransmissionType transmissionType;
        Account account;
        AccountServiceImpl service = new AccountServiceImpl();
        AdvertServiceImpl advertServiceImpl = new AdvertServiceImpl();
        String messageManager;
        try {
            account = service.createAccount(parameterMap);
            List<Advert> userAdvertList = advertServiceImpl.findAdvertBelongAccount(account);
            content.putSessionAttribute(ATTR_NAME_LIST_USER_ADVERT, userAdvertList);
            List<Advert> allAdvertList = advertServiceImpl.findAllAdvert();
            content.putSessionAttribute(ATTR_NAME_LIST_ALL_ADVERT, allAdvertList);
            content.putRequestAttribute(ATTR_NAME_USER, name);
            content.putSessionAttribute(ATTR_NAME_USER, name);
            content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, Role.USER.name());
            content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            content.putRequestAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            content.putSessionAttribute(ATTR_NAME_LOGIN, login);
            content.putSessionAttribute(ATTR_OBJECT_ADVERT, account);
            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            transmissionType = TransmissionType.REDIRECT;
        } catch (ServiceException | DaoException e) {
            messageManager = e.getMessage().trim();
            content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE,
                    MessageManager.getProperty(MESSAGE_INCORRECT_SIGN_UP_DATA, String.valueOf(ENGLISH)));
            String[] splitAttr = messageManager.split("\t");
            for (String element : splitAttr) {
                switch (element.trim()) {
                    case NAME_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_NAME,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case LOGIN_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_LOGIN,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case PASSWORD_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_PASSWORD,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case BIRTHDAY_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_BIRTHDAY,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case EMAIL_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_EMAIL,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case TEL_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_TEL,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case NON_CONFIRM_PASSWORD_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_PASS_NO_EQUALS_PASS_CONFIRM,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case BUSY_LOGIN_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_BUSY_LOGIN,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                }
            }
            page = CommandUrlBuilder.TO_SIGN_UP_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
            transmissionType = TransmissionType.REDIRECT;
        }
        return new Router(page, transmissionType);
    }
}