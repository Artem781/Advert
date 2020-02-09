package by.it.advertproject.command;

import by.it.advertproject.command.impl.EmptyCommand;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_WRONG_ACTION;
import static java.util.Locale.ENGLISH;
import static by.it.advertproject.command.Message.COMMAND_NOT_DEFINE_ERROR;

public class CommandFactory {
    private static Logger Logger = LogManager.getRootLogger();

    public static final String PARAM_NAME_COMMAND = "command";

    private static final String WRONG_ACTION_MESSAGE = "message.wrong-action";

    public static Command defineCommand(RequestContent content)
            throws CommandException {
        Command current;
        String action = content.getRequestParameters(PARAM_NAME_COMMAND,0);
        Logger.log(Level.INFO,"from CommandFactory)defineCommand. String action: " + action);
        if (action == null || action.isEmpty()) {
            throw new CommandException(COMMAND_NOT_DEFINE_ERROR);
        }
        try {
            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
            Logger.log(Level.INFO, "from CommandFactory)defineCommand. currentEnum: " + currentEnum.name());
            current = currentEnum.getCommand();
            if(current == null){
                // TODO: 05.09.2019 бросать исключение? нет
                Logger.log(Level.WARN, "from CommandFactory)defineCommand. if(current == null){");
            }
        } catch (IllegalArgumentException e) {
            Logger.log(Level.INFO, "from CommandFactory)defineCommand. catch block");

            content.putRequestAttribute(ATTR_NAME_WRONG_ACTION,
                    action + MessageManager.getProperty(WRONG_ACTION_MESSAGE, String.valueOf(ENGLISH)));
            throw new CommandException(COMMAND_NOT_DEFINE_ERROR);
        }
        Logger.log(Level.INFO, " return current;");
        return current;
    }
}







//
//    Command current = null;
//        if (action == null || action.isEmpty()) {
//                return new EmptyCommand();
//                }
//// получение объекта, соответствующего команде
//                try {
//                CommandType currentType = CommandType
//                .valueOf(action.toUpperCase());
//                System.out.println("from CommandFactory) CommandType: " + currentType.name());
//                current = currentType.getCommand();
//                } catch (IllegalArgumentException e) {
//                Logger.log(Level.ERROR, e.getMessage(), e);
//                current = new EmptyCommand();
////            request.setAttribute("wrongAction", action
////                    + MessageManager.getProperty("message.wrongaction"));
//                }
//                return current;