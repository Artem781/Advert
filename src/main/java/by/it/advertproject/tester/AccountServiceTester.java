package by.it.advertproject.tester;

import by.it.advertproject.bean.Role;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;

import java.util.*;
import java.util.regex.Pattern;

public class AccountServiceTester {
    private final static String LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
    private final static String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";
    private final static String NAME_REGEX = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
    private final static String DATE_BIRTHDAY_REGEX = "^(|(0[1-9])|(1[0-2]))\\/((0[1-9])|(1\\d)|(2\\d)|(3[0-1]))\\/((\\d{4}))$";
    private final static String EMAIL_REGEX = "^.+@[^\\.].*\\.[a-z]{2,}$";
    private final static String TEL_REGEX = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$";


    public static void main(String[] args) {
        String tomcat = "tomcat";
        AccountService accountService = new AccountService();
//        try {
//            accountService.createAccount(
//                    tomcat, tomcat, tomcat, tomcat, tomcat, tomcat, tomcat,  Role.valueOf("user".toUpperCase()) );
//        } catch (ServiceException e) {
//            System.out.println("Exception");
//        }


//        if ((!(Pattern.matches(NAME_REGEX, tomcat))) ||
//                (!(Pattern.matches(LOGIN_PATTERN, tomcat))) ||
//                (!(Pattern.matches(PASSWORD_PATTERN, tomcat))) ||
//                (!(Pattern.matches(DATE_BIRTHDAY_REGEX, tomcat))) ||
//                (!(Pattern.matches(EMAIL_REGEX, tomcat))) ||
//                (!(Pattern.matches(TEL_REGEX, tomcat)))) {
//            System.out.println("from AccountService) method createAccount) not valid data ");
//        }

        if (Pattern.matches(NAME_REGEX, tomcat) ||
                Pattern.matches(LOGIN_PATTERN, tomcat) ||
                Pattern.matches(PASSWORD_PATTERN, tomcat) ||
                Pattern.matches(DATE_BIRTHDAY_REGEX, tomcat) ||
                Pattern.matches(EMAIL_REGEX, tomcat) ||
                Pattern.matches(TEL_REGEX, tomcat)) {
            System.out.println("from AccountService) method createAccount) not valid data ");
        }


        String[] matchesRegEx = new String[]{"^[a-z0-9_-]{3,16}$",
                "^[a-z0-9_-]{6,18}$",
                "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})",
                "^(|(0[1-9])|(1[0-2]))\\/((0[1-9])|(1\\d)|(2\\d)|(3[0-1]))\\/((\\d{4}))$",
                "^.+@[^\\.].*\\.[a-z]{2,}$",
                "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$"};

//        for (String element: matchesRegEx){
//            if (Pattern.matches(element, tomcat)){
//                System.out.println( tomcat + " matches " + element);
//            }else {
//                System.out.println(tomcat + " not matches " + element);
//            }
//        }

//
//        Map<String, String> regExs = new HashMap();
//        regExs.put("login", "^[a-z0-9_-]{3,16}$");
//        regExs.put("password", "^[a-z0-9_-]{6,18}$");
//        regExs.put("name", "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})");
//        regExs.put("birthday", "^(|(0[1-9])|(1[0-2]))\\/((0[1-9])|(1\\d)|(2\\d)|(3[0-1]))\\/((\\d{4}))$");
//        regExs.put("email", "^.+@[^\\.].*\\.[a-z]{2,}$");
//        regExs.put("tel", "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$");
//        for (Map.Entry<String, String> element : regExs.entrySet()) {
//            String key = element.getKey();
//            String value = element.getValue();
//
//            boolean matches = Pattern.matches(value, tomcat);
//            System.out.println(key +" " + matches + value);
////            if (Pattern.matches(value, tomcat)) {
////                System.out.println(key + " matches " + value);
////            } else {
////                System.out.println(key + " not matches " + value);
////            }
//        }
//
//        List keyMap = new ArrayList(regExs.keySet());
//        List valuesMap = new ArrayList(regExs.values());
//        List<String> listMap = new ArrayList(regExs.entrySet());
////        System.out.println(keyMap);
//        Collections.sort(keyMap);
////        System.out.println(keyMap);

    }
}
