package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToIndexCommand implements Command {

    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) {
        String page = "index.jsp";
        Logger.log(Level.INFO, "from ToIndexCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
