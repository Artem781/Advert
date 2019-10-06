package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToCreateAdvertCommand implements Command {
    private static Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) throws CommandException {
        String page = "/jsppage/createad.jsp";
        Logger.log(Level.INFO, "from ToCreateAdvertCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
