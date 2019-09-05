package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;

import javax.servlet.http.HttpServletRequest;

public class ForwardToSignUpCommand implements Command {
    @Override
//    public String execute(HttpServletRequest request) {
    public Router execute(RequestContent content) {

        String page = "/jsppage/signup.jsp";
        System.out.println("from ForwardToSignUpCommand. page: " + page);
//        return page;
        return new Router(page, TransmissionType.REDIRECT);
    }
}
