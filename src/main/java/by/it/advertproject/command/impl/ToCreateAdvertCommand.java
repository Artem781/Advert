package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToCreateAdvertCommand implements Command {
    private static Logger Logger = LogManager.getRootLogger();
    private static final String CREATE_AD_PAGE = "path.page.createad";

    @Override
    public Router execute(RequestContent content) {
        String page = ConfigurationManager.getProperty(CREATE_AD_PAGE);
        Logger.log(Level.INFO, "from ToCreateAdvertCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
