package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE;

public class SetLanguageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SetLanguageCommand.class);
    private static final String NEXT_PAGE_EXCEPTION = "next page exception";
    private static final String MAIN = "to-main";
    private static final String CREATE_AD = "to-createad";
    private static final String SIGN_IN = "to-signin";
    private static final String SIGN_UP = "to-signup";
    private static final String USER_PROFILE = "to-userprofile";
    private static final String ADMIN_PROFILE = "to-adminprofile";
    private static final String EDIT_PROFILE = "to_edit_profile";
    private static final String SIGN_IN_PAGE = "path.page.signin";
    private static final String SIGN_UP_PAGE = "path.page.signup";
    private static final String MAIN_PAGE = "path.page.main";
    private static final String CREATE_AD_PAGE = "path.page.createad";
    private static final String USER_PROFILE_PAGE = "path.page.userprofile";
    private static final String ADMIN_PROFILE_PAGE = "path.page.adminprofile";
    private static final String EDIT_PROFILE_PAGE = "path.page.editprofile";
    private static final String RUSSIAN = "ru";
    public static final String ENGLISH = "en";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        LOGGER.log(Level.INFO, "SetLanguageCommand");
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
        switch (nextPage) {
            case MAIN:
                page = ConfigurationManager.getProperty(MAIN_PAGE);
                break;
            case CREATE_AD:
                page = ConfigurationManager.getProperty(CREATE_AD_PAGE);
                break;
            case SIGN_IN:
                page = ConfigurationManager.getProperty(SIGN_IN_PAGE);
                break;
            case SIGN_UP:
                page = ConfigurationManager.getProperty(SIGN_UP_PAGE);
                break;
            case USER_PROFILE:
                page = ConfigurationManager.getProperty(USER_PROFILE_PAGE);
                break;
            case ADMIN_PROFILE:
                page = ConfigurationManager.getProperty(ADMIN_PROFILE_PAGE);
                break;
            case EDIT_PROFILE:
                page = ConfigurationManager.getProperty(EDIT_PROFILE_PAGE);
                break;
            default:
                throw new CommandException(NEXT_PAGE_EXCEPTION);
        }
        return new Router(page, TransmissionType.FORWARD);
    }
}
