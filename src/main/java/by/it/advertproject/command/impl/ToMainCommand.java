package by.it.advertproject.command.impl;

import by.it.advertproject.command.ActionCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class ToMainCommand implements ActionCommand {

    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();
    private static final String MAIN_PAGE = "path.page.main";

    @Override
    public Router execute(RequestContent content) {
        Logger.log(Level.INFO, "ToMainCommand");
//        String page = ConfigurationManager.getProperty(MAIN_PAGE);
        String page = MAIN_PAGE;
        return new Router(page, TransmissionType.FORWARD);
    }
}
