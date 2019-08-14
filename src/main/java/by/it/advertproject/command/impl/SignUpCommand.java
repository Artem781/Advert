package by.it.advertproject.command.impl;

import by.it.advertproject.command.Command;
import by.it.advertproject.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
  private static final String PARAM_NAME = "name";
  private static final String PARAM_LOGIN = "login";
  private static final String PARAM_PASSWORD = "password";
  private static final String PARAM_DATE_OF_BIRTH = "dateofbirth";
  private static final String PARAM_EMAIL = "email";
  private static final String PARAM_TEL = "tel";
  private static final String PARAM_ACCESS_LEVEL = "accesslevel";

    @Override
    public String execute(HttpServletRequest request) {
        AccountService service = new AccountService();

        String page = null;
        String name = request.getParameter(PARAM_NAME);
        String password = request.getParameter(PARAM_PASSWORD);
        String dateOfBirth = request.getParameter(PARAM_DATE_OF_BIRTH);
        String email = request.getParameter(PARAM_EMAIL);
        String tel = request.getParameter(PARAM_TEL);
        String accessLevel = request.getParameter(PARAM_ACCESS_LEVEL);





        return null;
    }
}
