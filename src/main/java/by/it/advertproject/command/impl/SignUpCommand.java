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
import java.util.LinkedList;
import java.util.Map;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;
import static java.util.Locale.ENGLISH;

public class SignUpCommand implements Command {
    private static Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public Router execute(RequestContent content) {
        logger.log(Level.INFO, "from SignUpCommand");
        String page;
        Map<String, String> parameterMap = new HashMap<>();
        String name = content.getRequestParameters(PARAM_NAME, 0);
        parameterMap.put(PARAM_NAME, name);
        String login = content.getRequestParameters(PARAM_NAME_LOGIN, 0);
        parameterMap.put(PARAM_NAME_LOGIN, login);
        String pass = content.getRequestParameters(PARAM_PASSWORD, 0);
        parameterMap.put(PARAM_PASSWORD, pass);
        String confirmPass = content.getRequestParameters(PARAM_PASSWORD_CONFIRM, 0);
        parameterMap.put(PARAM_PASSWORD_CONFIRM, confirmPass);
        String birthday = content.getRequestParameters(PARAM_BIRTHDAY, 0);
        parameterMap.put(PARAM_BIRTHDAY, birthday);
        String email = content.getRequestParameters(PARAM_EMAIL, 0);
        parameterMap.put(PARAM_EMAIL, email);
        String tel = content.getRequestParameters(PARAM_TEL, 0);
        parameterMap.put(PARAM_TEL, tel);
//    Role role = Role.valueOf(request.getParameter(PARAM_ACCESS_LEVEL).toUpperCase());
        content.putRequestAttribute(ATTR_NAME_USER, name);
        content.putRequestAttribute(ATTR_NAME_LOGIN, login);
        content.putRequestAttribute(ATTR_NAME_BIRTHDAY, birthday);
        content.putRequestAttribute(ATTR_NAME_EMAIL, email);
        content.putRequestAttribute(ATTR_NAME_TELEPHONE, tel);
        content.putRequestAttribute(ATTR_NAME_ACCESS_LEVEL, Role.USER);
        TransmissionType transmissionType;
        Account account;
        AccountService service = new AccountService();
        logger.log(Level.INFO, "from SignUpCommand before try block");
        String messageManager = "";
        try {
//            account = service.createAccount(name, login, pass, confirmPass, birthday, email, tel);
            account = service.createAccount(parameterMap);
            logger.log(Level.INFO, "from SignUpCommand) try block) account: " + account);
            content.putSessionAttribute(ATTR_NAME_USER, name);
            content.putSessionAttribute(ATTR_NAME_ACCESS_LEVEL, Role.USER);
            content.putSessionAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            content.putSessionAttribute(ATTR_NAME_LOGIN, login);
            logger.log(Level.INFO, "from SignUpCommand. before page.");
            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, String.valueOf(account.getId())).getUrl();
            transmissionType = TransmissionType.FORWARD;
            logger.log(Level.INFO, "from SignUpCommand. page: " + page);
        } catch (ServiceException e) {
            logger.log(Level.INFO, "from SignUpCommand. catch block. e.getMessage(): " + e.getMessage());
            messageManager = e.getMessage().trim();
            content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE,
                    MessageManager.getProperty(MESSAGE_INCORRECT_SIGN_UP_DATA, String.valueOf(ENGLISH)));
            String[] splitAttr = messageManager.split("\t");
            for (String element : splitAttr) {
                logger.log(Level.INFO, "element: " + element);
                switch (element.trim()) {
                    case NAME_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_NAME,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case LOGIN_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_LOGIN,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case PASSWORD_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_PASSWORD,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case BIRTHDAY_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_BIRTHDAY,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case EMAIL_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_EMAIL,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case TEL_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_TEL,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case NON_CONFIRM_PASSWORD_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_PASS_NO_EQUALS_PASS_CONFIRM,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case BUSY_LOGIN_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_BUSY_LOGIN,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                }
            }


//            logger.log(Level.INFO, MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
//            page = CommandUrlBuilder.TO_REGISTRATION
//            content.putRequestAttribute("errorMessageAttr", MessageManager.getProperty(e.getMessage(), String.valueOf(ENGLISH)));
            page = CommandUrlBuilder.TO_SIGN_UP_PAGE
//                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage()).getUrl();
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
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