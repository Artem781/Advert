package by.it.advertproject.command;

import by.it.advertproject.command.impl.EmptyCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    private static Logger Logger = LogManager.getRootLogger();

    public static Command defineCommand(String action) {
        Command current = null;
        if (action == null || action.isEmpty()) {
            return new EmptyCommand();
        }
// получение объекта, соответствующего команде
        try {
            CommandType currentType = CommandType
                    .valueOf(action.toUpperCase());
            System.out.println("from CommandFactory) CommandType: " + currentType.name());
            current = currentType.getCommand();
        } catch (IllegalArgumentException e) {
            Logger.log(Level.ERROR, e.getMessage(), e);
            current = new EmptyCommand();
//            request.setAttribute("wrongAction", action
//                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
