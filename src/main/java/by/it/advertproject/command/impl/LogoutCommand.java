package by.it.advertproject.command.impl;


import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
//    public String execute(HttpServletRequest request) {
    public Router execute(RequestContent content) {

//        String page = ConfigurationManager.getProperty("path.page.index");
        String page = "/index.jsp";
        System.out.println("from LogoutCommand. return page: " + page);

// уничтожение сессии
//        request.getSession().invalidate();
        content.invalidateSession();
//        return page;
        return new Router(page, TransmissionType.REDIRECT);
    }
}
