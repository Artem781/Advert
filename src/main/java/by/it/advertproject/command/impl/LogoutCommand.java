package by.it.advertproject.command.impl;


import by.it.advertproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
//        String page = ConfigurationManager.getProperty("path.page.index");
        String page = "/index.jsp";
        System.out.println("from LogoutCommand. return page: "+page );

// уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
