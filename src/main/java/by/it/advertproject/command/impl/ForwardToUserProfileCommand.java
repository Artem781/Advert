package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForwardToUserProfileCommand implements Command {
    private static Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) {
        String page = "/jsppage/userprofile.jsp";
        Logger.log(Level.INFO, "from ForwardToUserProfileCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);

    }
}
