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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.*;
import static java.util.Locale.ENGLISH;

public class SignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public Router execute(RequestContent content) {
        String page;
        String name = content.getRequestParameters(PARAM_NAME, 0);
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        String pass = content.getRequestParameters(PARAM_PASSWORD, 0);
        String confirm = content.getRequestParameters(PARAM_PASSWORD_CONFIRM, 0);
        String birthday = content.getRequestParameters(PARAM_BIRTHDAY, 0);
        String email = content.getRequestParameters(PARAM_EMAIL, 0);
        String tel = content.getRequestParameters(PARAM_TEL, 0);
//    Role role = Role.valueOf(request.getParameter(PARAM_ACCESS_LEVEL).toUpperCase());
        TransmissionType transmissionType;
        Account account;
        AccountService service = new AccountService();
        try {
            account = service.createAccount(name, login, pass, confirm, birthday, email, tel);
            content.putSessionAttribute(ATTR_NAME_USER, login);
            content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, Role.USER);
            content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            content.putSessionAttribute(ATTR_NAME_LOGIN, login);
//            page = CommandUrlBuilder.TO_PERSONAL_PAGE
            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            transmissionType = TransmissionType.FORWARD;
        } catch (ServiceException e) {
            logger.log(Level.INFO, MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
//            page = CommandUrlBuilder.TO_REGISTRATION
            page = CommandUrlBuilder.TO_SIGN_UP_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage()).getUrl();
            transmissionType = TransmissionType.FORWARD;
        }
        return new Router(page, transmissionType);
    }
    }






//
//    AccountService service = new AccountService();
//    Account account;
//    String page = null;
//    String name = request.getParameter(PARAM_NAME);
//    String login = request.getParameter(PARAM_NAME_LOGIN);
//    String password = request.getParameter(PARAM_PASSWORD);
//    String passwordConfirm = request.getParameter(PARAM_PASSWORD_CONFIRM);
//    String birthday = request.getParameter(PARAM_BIRTHDAY);
//    String email = request.getParameter(PARAM_EMAIL);
//    String tel = request.getParameter(PARAM_TEL);
//    Role role = Role.valueOf(request.getParameter(PARAM_ACCESS_LEVEL).toUpperCase());
////        System.out.println("name: " + name + "\n" +
////                           "login: " + login + "\n" +
////                           "password: " + password + "\n" +
////                           "passwordConfirm: " + passwordConfirm + "\n" +
////                           "birthday: " + birthday + "\n" +
////                           "email: " + email + "\n" +
////                           "tel: " + tel + "\n" +
////                           "role" + role.name() + "\n");
//        try {
//                account = service.createAccount(name, login, password, passwordConfirm,
//                birthday, email, tel, role);
//                request.setAttribute(ATTR_NAME_USER, account.getName());
//                page = "/jsppage/userprofile.jsp";
//                } catch (ServiceException e) {
//                request.setAttribute(ATTR_NAME_CHECK_ENTER_DATA, e.getMessage());
//                logger.log(Level.INFO, e.getMessage());
//                page = "/jsppage/signup.jsp";
//                }
//                return page;
//                }