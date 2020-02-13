package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToUserProfileCommand implements ActionCommand {
    private static Logger Logger = LogManager.getRootLogger();
    private static final String USER_PROFILE_PAGE = "path.page.userprofile";

    @Override
    public Router execute(RequestContent content) {
        Logger.log(Level.INFO, "ToUserProfileCommand");
        String page = ConfigurationManager.getProperty(USER_PROFILE_PAGE);
        return new Router(page, TransmissionType.FORWARD);

    }
}
