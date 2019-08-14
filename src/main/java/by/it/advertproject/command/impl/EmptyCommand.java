package by.it.advertproject.command.impl;


import by.it.advertproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

//        String page = ConfigurationManager.getProperty("path.page.index");
        String page = "/index.jsp";

        return page;
    }
}
