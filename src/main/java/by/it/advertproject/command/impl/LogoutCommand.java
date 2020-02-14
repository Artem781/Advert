package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getRootLogger();
    private static final String LOG_OUT_PAGE = "path.page.index";

    @Override
    public Router execute(RequestContent content) {
        String page = ConfigurationManager.getProperty(LOG_OUT_PAGE);
        LOGGER.log(Level.INFO, "LogoutCommand");
        content.invalidateSession();
        return new Router(page, TransmissionType.FORWARD);
    }
}
