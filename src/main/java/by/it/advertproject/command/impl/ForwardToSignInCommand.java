package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ForwardToSignInCommand implements Command {
    private static Logger Logger = LogManager.getRootLogger();

    @Override
//    public String execute(HttpServletRequest request) {
    public Router execute(RequestContent content) {

        String page = "/jsppage/signin.jsp";
//        String page = "/WEB-INF/jsp/signin.jsp";
        Logger.log(Level.INFO, "from ForwardToSignInCommand. page: " + page);
//        return page;
        return new Router(page, TransmissionType.FORWARD);
    }
}
