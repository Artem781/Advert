package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToSignUpCommand implements ActionCommand {
    private static Logger Logger = LogManager.getRootLogger();
    private static final String SIGN_UP_PAGE = "path.page.signup";

    @Override
    public Router execute(RequestContent content) {
        Logger.log(Level.INFO, "ToSignUpCommand");
        String page = ConfigurationManager.getProperty(SIGN_UP_PAGE);
        return new Router(page, TransmissionType.FORWARD);
    }
}
