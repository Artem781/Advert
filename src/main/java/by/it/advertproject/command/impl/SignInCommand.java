package by.it.advertproject.command.impl;


import by.it.advertproject.command.Command;
import by.it.advertproject.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    // в константы строки
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        //  -----  07.08.2019 где правильно создавать  объект AccountService,
        //в методе или полем класса?
        //  и надо ли присваивать null вконце метода
        AccountService service = new AccountService();

        String page ;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if (service.checkLoginPass(login, pass)) {
            request.setAttribute("user", login);
// определение пути к userprofile.jsp
            //тут берется из property
//            page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsppage/userprofile.jsp";
        } else {
//            request.setAttribute( "patternLogin","Login contains: letters, numbers, hyphens and underscores, from 3 to 16 characters.");
//            request.setAttribute( "patternPassword","Password contains: letters, numbers, hyphens and underscores, from 6 to 18 characters.");
            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror"));
                    "incorrect login or password");
//            page = ConfigurationManager.getProperty("path.page.login");
        page = "/jsppage/signin.jsp";
//            page = "/index.jsp";
        }
        service = null;
        System.out.println("from SigninCommand. page: " + page);

        return page;
    }
}
