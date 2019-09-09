package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
//        String execute(HttpServletRequest request);
    Router execute(RequestContent content) throws CommandException;
}
