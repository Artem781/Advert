package by.it.advertproject.filter;

import by.it.advertproject.bean.Role;

public class TesterFilter {
    public static void main(String[] args) {
        System.out.println(Role.ADMINISTRATOR);
        System.out.println(Role.ADMINISTRATOR.toString());
        System.out.println(Role.ADMINISTRATOR.name());
        Role administrator = Role.ADMINISTRATOR;
        String name = Role.ADMINISTRATOR.name();
        String s = Role.ADMINISTRATOR.toString();
    }
}
