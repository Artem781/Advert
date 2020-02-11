package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class ToMainCommand implements Command {

    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();
    private static final String MAIN_PAGE = "path.page.main";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        Logger.log(Level.INFO, "from ToMainCommand.");
        String page = ConfigurationManager.getProperty(MAIN_PAGE);
        Logger.log(Level.INFO, "from ToMainCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
