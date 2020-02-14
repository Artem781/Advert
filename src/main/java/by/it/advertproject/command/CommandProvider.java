package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_WRONG_ACTION;
import static java.util.Locale.ENGLISH;
import static by.it.advertproject.command.Message.COMMAND_NOT_DEFINE_ERROR;

public class CommandProvider {
    private static Logger Logger = LogManager.getRootLogger();
    public static final String PARAM_NAME_COMMAND = "command";
    private static final String WRONG_ACTION_MESSAGE = "message.wrong-action";

    public static ActionCommand defineCommand(RequestContent content) throws CommandException {
        Logger.log(Level.INFO, "CommandFactory");
        ActionCommand current;
        String action = content.getRequestParameters(PARAM_NAME_COMMAND, 0);
        if (action == null || action.isEmpty()) {
            throw new CommandException(COMMAND_NOT_DEFINE_ERROR);
        }
        try {
            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
            if (current == null) {
                Logger.log(Level.WARN, "current == null");
                throw new CommandException(WRONG_ACTION_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            content.putRequestAttribute(ATTR_NAME_WRONG_ACTION,
                    action + MessageManager.getProperty(WRONG_ACTION_MESSAGE, String.valueOf(ENGLISH)));
            throw new CommandException(COMMAND_NOT_DEFINE_ERROR);
        }
        return current;
    }
}