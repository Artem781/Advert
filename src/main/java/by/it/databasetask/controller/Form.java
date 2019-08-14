package by.it.databasetask.controller;

import by.it.advertproject.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class Form {

   public static boolean isPost(HttpServletRequest req) {

        return req.getMethod().equalsIgnoreCase("POST");
    }

   public static String getString(HttpServletRequest req, String name, String pattern) throws CommandException {
        String result = req.getParameter(name);
        if (result != null) {
            if (result.matches(pattern)) {
                return result;
            } else throw new CommandException("name=" + result + " incorrect");
        } else return null;


    }

    public static String getString(HttpServletRequest req, String name) throws CommandException {
        return getString(req, name, ".*");
    }

    public static double getDouble(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    public static int getInteger(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }

    public static long getLong(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }


}
