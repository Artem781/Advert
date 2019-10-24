package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToEditProfile implements Command {
    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) throws CommandException {
        String page = "/jsppage/editprofile.jsp";
        Logger.log(Level.INFO, "from ToEditProfileCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
