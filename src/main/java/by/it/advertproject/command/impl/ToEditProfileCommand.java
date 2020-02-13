package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class ToEditProfileCommand implements ActionCommand {
    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();
    private static final String EDIT_PROFILE_PAGE = "path.page.editprofile";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        Logger.log(Level.INFO, "ToEditProfileCommand");
        String page = ConfigurationManager.getProperty(EDIT_PROFILE_PAGE);
        return new Router(page, TransmissionType.FORWARD);
    }
}
