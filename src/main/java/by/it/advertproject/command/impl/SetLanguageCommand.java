package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.ConfigurationManager;
import by.it.advertproject.util.MessageManager;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_FEEDBACK;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE;

public class SetLanguageCommand implements Command {

    private static final String SETTING = "setting";
    private static final String LOGIN = "login";
    private static final String REGISTRATION = "registration";
    private static final String REGISTRATION_PAGE = "path.page.registration";
    private static final String SETTING_PAGE = "path.page.setting";
    private static final String LOGIN_PAGE = "path.page.login";
    private static final String EMPTY_STRING = "";
    private static final String RUSSIAN = "ru";
    public static final String ENGLISH = "en";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        String lang = (String) content.getSessionAttribute(ATTR_NAME_LANG);
        if (lang == null) {
            content.putSessionAttribute(ATTR_NAME_LANG, ENGLISH);
        } else {
            if (lang.equals(ENGLISH)) {
                lang = RUSSIAN;
                content.putSessionAttribute(ATTR_NAME_LANG, RUSSIAN);
            } else {
                lang = ENGLISH;
                content.putSessionAttribute(ATTR_NAME_LANG, ENGLISH);
            }
        }
        String nextPage = content.getRequestParameters(PARAM_NAME_PAGE, 0);
        String page = null;
        AccountService service = new AccountService();
        switch (nextPage) {
            case LOGIN:
                page = ConfigurationManager.getProperty(LOGIN_PAGE);
                break;
            case SETTING:
                long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
                try {
                    Account account = service.findAccount(accountId);
                    content.putRequestAttribute(ATTR_NAME_ACCOUNT, account);
                    String feedbackType = content.getRequestParameters(PARAM_NAME_FEEDBACK, 0);
                    if (feedbackType == null || feedbackType.isEmpty()) {
                        content.putRequestAttribute(ATTR_LOGIN_ERROR, EMPTY_STRING);
                    } else {
                        String error = MessageManager.getProperty(feedbackType, lang);
                        content.putRequestAttribute(ATTR_LOGIN_ERROR, error);
                    }
                } catch (ServiceException e) {
                    throw new CommandException(e.getMessage());
                }
                page = ConfigurationManager.getProperty(SETTING_PAGE);

                break;
            case REGISTRATION:
                page = ConfigurationManager.getProperty(REGISTRATION_PAGE);
                break;
        }
        return new Router(page, TransmissionType.FORWARD);
    }
}
