package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;

/**
 * interface that define execute load for commands that send media files to client
 */
public interface ImageLoadCommand {
    /**
     * @param requestContent - content that contains: request parameters,request attribute,
     *                      session attribute
     * @return array of bytes with media files data
     * @throws CommandException
     */
    byte[] load(RequestContent requestContent) throws CommandException;

}
