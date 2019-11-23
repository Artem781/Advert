package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.ConfigurationManager;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;

public class ToMainCommand implements Command {

    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    @Override
    public Router execute(RequestContent content) throws CommandException {
        Logger.log(Level.INFO, "from ToMainCommand.");


        String page = "/jsppage/main.jsp";
        Logger.log(Level.INFO, "from ToMainCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);
    }
}
