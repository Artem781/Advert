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

public class ToAdminProfileCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getRootLogger();
    private static final String ADMIN_PROFILE_PAGE = "path.page.adminprofile";

    @Override

    public Router execute(RequestContent content) throws CommandException {
        LOGGER.log(Level.INFO, "ToAdminProfileCommand");
        String page = ConfigurationManager.getProperty(ADMIN_PROFILE_PAGE);
        return new Router(page, TransmissionType.FORWARD);
    }
}
