package by.it.advertproject.command.impl;


import by.it.advertproject.command.Command;
import by.it.advertproject.service.AccountService;

import javax.servlet.http.HttpServletRequest;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.*;

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        AccountService service = new AccountService();
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (service.checkLoginPass(login, pass)) {
            request.setAttribute(ATTR_NAME_USER, login);
//            page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsppage/userprofile.jsp";
        } else {
            request.setAttribute(ATTR_NAME_ERROR_LOGIN_PASS_MESSAGE,
//                    MessageManager.getProperty("message.loginerror"));
                    "incorrect login or password");
//            page = ConfigurationManager.getProperty("path.page.login");
            page = "/jsppage/signin.jsp";
        }
        service = null;
        System.out.println("from SigninCommand. page: " + page);
        return page;
    }
}
