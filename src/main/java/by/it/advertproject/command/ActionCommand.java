package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;

/**
 * interface that define execute method for action commands
 */
public interface ActionCommand {
    /**
     * @param content - content that contains: request parameters,request attribute,
     *                session attribute
     * @return {@link Router}
     * @throws CommandException
     */
    Router execute(RequestContent content) throws CommandException;
}
