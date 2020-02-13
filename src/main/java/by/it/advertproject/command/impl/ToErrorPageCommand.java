package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.MissingResourceException;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_LANG;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_ERROR_MESSAGE;

public class ToErrorPageCommand implements ActionCommand {
    private static final String ERROR_PAGE = "path.page.error";
    private static final String UNKNOWN_ERROR = "Unknown error";
    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) {
        Logger.log(Level.INFO, "ToErrorPageCommand");
        String lang = (String) content.getSessionAttribute(ATTR_NAME_LANG);
        String errorMessage;
        try {
            errorMessage = MessageManager
                    .getProperty(content
                            .getRequestParameters(PARAM_NAME_ERROR_MESSAGE, 0), lang);
        } catch (MissingResourceException e) {
            errorMessage = UNKNOWN_ERROR;
        }
        content.putRequestAttribute(PARAM_NAME_ERROR_MESSAGE, errorMessage);
        String page = ConfigurationManager.getProperty(ERROR_PAGE);
        return new Router(page, TransmissionType.FORWARD);
    }
}
