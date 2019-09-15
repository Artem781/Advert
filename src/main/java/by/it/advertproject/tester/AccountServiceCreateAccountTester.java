package by.it.advertproject.tester;

import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;

import java.util.HashMap;
import java.util.Map;

import static by.it.advertproject.command.ParameterName.*;

public class AccountServiceCreateAccountTester {
    public static void main(String[] args) {
        String name = "ivaname";
        String login = "ivanlogin";
        String password = "ivanpass";
        String passwordConfirm = "ivanpass";
        String birthday = "1995-07-11";
        String email = "ivanemail@tut.by";
        String tel = "+375285832823";

        Map<String, String> testParm = new HashMap<>();
        testParm.put(PARAM_NAME, name);
        testParm.put(PARAM_NAME_LOGIN, login);
        testParm.put(PARAM_PASSWORD, password);
        testParm.put(PARAM_PASSWORD_CONFIRM, passwordConfirm);
        testParm.put(PARAM_BIRTHDAY, birthday);
        testParm.put(PARAM_EMAIL, email);
        testParm.put(PARAM_TEL, tel);
        System.out.println(testParm.size());

        AccountService accountService = new AccountService();
        try {
            accountService.createAccount(testParm);
        } catch (ServiceException e) {
            System.out.println("CATCH BLOCK. e: " + e.getMessage());
        }
    }
}
