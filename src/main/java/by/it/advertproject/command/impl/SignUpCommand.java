package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.Command;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

//todo как правильно устанавливать access level?
public class SignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);
    private static final String PARAM_NAME = "name";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "passwordfirst";
    private static final String PARAM_PASSWORD_CONFIRM = "passwordsecond";
    private static final String BIRTHDAY = "birthday";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_TEL = "tel";
    private static final String PARAM_ACCESS_LEVEL = "accesslevel";

    @Override
    public String execute(HttpServletRequest request) {
        AccountService service = new AccountService();
        Account account;
        String page = null;
        String name = request.getParameter(PARAM_NAME);
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        String passwordConfirm = request.getParameter(PARAM_PASSWORD_CONFIRM);
        String birthday = request.getParameter(BIRTHDAY);
        String email = request.getParameter(PARAM_EMAIL);
        String tel = request.getParameter(PARAM_TEL);
        Role role = Role.valueOf(request.getParameter(PARAM_ACCESS_LEVEL).toUpperCase());
        System.out.println("name: " + name + "\n" +
                           "login: " + login + "\n" +
                           "password: " + password + "\n" +
                           "passwordConfirm: " + passwordConfirm + "\n" +
                           "birthday: " + birthday + "\n" +
                           "email: " + email + "\n" +
                           "tel: " + tel + "\n" +
                           "role" + role.name() + "\n");
        try {
            account = service.createAccount(name, login, password, passwordConfirm,
                    birthday, email, tel, role);
            request.setAttribute("user", account.getName());
            page = "/jsppage/userprofile.jsp";
        } catch (ServiceException e) {
            request.setAttribute("checkEnterData", "check the entered data.");
            logger.log(Level.INFO, e.getMessage());
            page = "/jsppage/signup.jsp";
        }
        return page;
    }
}
