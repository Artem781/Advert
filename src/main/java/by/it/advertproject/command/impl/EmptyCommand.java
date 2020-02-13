package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmptyCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getRootLogger();
    private static final String INDEX_PAGE = "path.page.index";

    @Override
    public Router execute(RequestContent content) {
        LOGGER.log(Level.INFO, "EmptyCommand");
        String page = INDEX_PAGE;
        return new Router(page, TransmissionType.FORWARD);
    }
}
