package by.it.advertproject.tester.examl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] args) {
//        String regex = "\\w/{1,4}";
        String regex = "[a-zA-Zа-яА-Я0-9_ -]{1,49}";
//        String regex = "[+][\\d]{5}[-][\\d]{7}";
        String text = "+37529-5832823";
//        String text = "A__4";

//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(text);
        boolean matches = text.matches(regex);
        System.out.println(matches);
    }
}
