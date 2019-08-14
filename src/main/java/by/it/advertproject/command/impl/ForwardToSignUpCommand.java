package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ForwardToSignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsppage/signup.jsp";
        System.out.println("from ForwardToSignUpCommand. page: " + page);
        return page;
    }
}
