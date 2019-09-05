package by.it.advertproject.command.impl;


import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.*;
import static java.util.Locale.ENGLISH;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);

    public Router execute(RequestContent content) {
        String page = null;
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        String pass = content.getRequestParameters(PARAM_NAME_PASSWORD, 0);
        TransmissionType transmissionType = TransmissionType.REDIRECT;
        Account account;
        AccountService service = new AccountService();
        try {
            account = service.checkLogin(login, pass);
            if (account.getRole().equals(Role.USER)) {
                content.putSessionAttribute(ATTR_NAME_USER, login);
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                page = CommandUrlBuilder.TO_PERSONAL_PAGE.
                        setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            } else if (account.getRole().equals(Role.ADMINISTRATOR)) {
                content.putRequestAttribute(ATTR_NAME_USER, login);
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                page = CommandUrlBuilder.TO_PERSONAL_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            }
        } catch (ServiceException e) {
            logger.log(Level.INFO, MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
            System.out.println( String.valueOf(ENGLISH));
            page = CommandUrlBuilder.TO_LOGIN
                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage())
                    .getUrl();
            transmissionType = TransmissionType.REDIRECT;
        }
        return new Router(page, transmissionType);

    }
}






//
//        if (service.checkLogin(login, pass)) {
//                request.setAttribute(ATTR_NAME_USER, login);
////            page = ConfigurationManager.getProperty("path.page.main");
//                page = "/jsppage/userprofile.jsp";
//                } else {
//                request.setAttribute(ATTR_NAME_ERROR_LOGIN_PASS_MESSAGE,
////                    MessageManager.getProperty("message.loginerror"));
//                "incorrect login or password");
////            page = ConfigurationManager.getProperty("path.page.login");
//                page = "/jsppage/signin.jsp";
//                }
//                service = null;
//                System.out.println("from SignInCommand. page: " + page);
////        return page;
//                return new Router(page, TransmissionType.REDIRECT);
//                }