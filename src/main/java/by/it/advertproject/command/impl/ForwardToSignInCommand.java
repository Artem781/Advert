package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ForwardToSignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsppage/signin.jsp";
        System.out.println("from ForwardToSignInCommand. page: " + page);
        return page;
    }
}
