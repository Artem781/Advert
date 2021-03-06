package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.ATTR_LOGIN_ERROR;
import static by.it.advertproject.command.AttributeName.ATTR_NAME_LANG;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_FEEDBACK;

public class ToSignInCommand implements ActionCommand {
    private static Logger Logger = LogManager.getRootLogger();
    private static final String SIGN_IN_PAGE = "path.page.signin";
    private static final String EMPTY_STRING = "";

    @Override
    public Router execute(RequestContent content) {
        Logger.log(Level.INFO, "ToSignInCommand");
        String page = ConfigurationManager.getProperty(SIGN_IN_PAGE);
        String lang = (String) content.getSessionAttribute(ATTR_NAME_LANG);
        String feedbackType = content.getRequestParameters(PARAM_NAME_FEEDBACK, 0);
        if (feedbackType == null) {
            content.putRequestAttribute(ATTR_LOGIN_ERROR, EMPTY_STRING);
        } else {
            String feedback = MessageManager.getProperty(feedbackType, lang);
            content.putRequestAttribute(ATTR_LOGIN_ERROR, feedback);
        }
        return new Router(page, TransmissionType.FORWARD);
    }
}
