package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;

import javax.servlet.http.HttpServletRequest;

public class ForwardToSignInCommand implements Command {
    @Override
//    public String execute(HttpServletRequest request) {
    public Router execute(RequestContent content) {

        String page = "/jsppage/signin.jsp";
        System.out.println("from ForwardToSignInCommand. page: " + page);
//        return page;
        return new Router(page, TransmissionType.REDIRECT);
    }
}
