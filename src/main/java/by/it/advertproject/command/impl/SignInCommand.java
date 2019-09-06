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
    private static Logger logger = LogManager.getLogger(SignInCommand.class);

    public Router execute(RequestContent content) {
        String page = null;
//        String page =  "/jsppage/userprofile.jsp";
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        logger.log(Level.INFO, "from SignInCommand. String login = " + login);
        String pass = content.getRequestParameters(PARAM_NAME_PASSWORD, 0);
        logger.log(Level.INFO, "from SignInCommand. String pass = " + pass);
        TransmissionType transmissionType = TransmissionType.FORWARD;
        Account account;
        AccountService service = new AccountService();
        try {
            account = service.checkLogin(login, pass);
            logger.log(Level.INFO, "from SignInCommand." + " create account: account = service.checkLogin(login, pass);");
            logger.log(Level.INFO, "account.getRole()" + account.getRole());
            if (account.getRole().equals(Role.USER)) {
                logger.log(Level.INFO, "user role: USER");
                content.putSessionAttribute(ATTR_NAME_USER, login);
                logger.log(Level.INFO, "ATTR_NAME_USER = \"user\"\t values: " + login);
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                logger.log(Level.INFO, "ATTR_NAME_ACCESS_LEVEL = \"access_level\"\t values: "
                        + account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                logger.log(Level.INFO, "ATTR_NAME_ACCOUNT_ID = \"accountId\"\t values: "
                        + account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                logger.log(Level.INFO, "ATTR_NAME_LOGIN = \"login\"\t values: " + login);
                logger.log(Level.INFO, "PARAM_NAME_PAGE_ID = \"page_id\"\t values: " + PARAM_NAME_PAGE_ID);
                logger.log(Level.INFO, "String.valueOf(account.getId()): " + String.valueOf(account.getId()));
//                page = CommandUrlBuilder.TO_PERSONAL_PAGE.
                page = CommandUrlBuilder.TO_USER_PROFILE_PAGE.setParams(
                        PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
                logger.log(Level.INFO, "page: " + page);
            } else if (account.getRole().equals(Role.ADMINISTRATOR)) {
                logger.log(Level.INFO, "user role: ADMINISTRATOR");
                content.putRequestAttribute(ATTR_NAME_USER, login);
                content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, account.getRole());
                content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
                content.putSessionAttribute(ATTR_NAME_LOGIN, login);
                page = CommandUrlBuilder.TO_PERSONAL_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            }
        } catch (ServiceException e) {
            logger.log(Level.INFO, MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
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