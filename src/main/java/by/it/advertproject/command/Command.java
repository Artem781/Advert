package by.it.advertproject.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
//        String execute(HttpServletRequest request);
    Router execute(RequestContent content);
}
