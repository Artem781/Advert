package by.it.advertproject.command;

import by.it.advertproject.command.impl.img.LoadAccountPhotoCommand;
import by.it.advertproject.command.impl.img.LoadPostImageCommand;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.Message.COMMAND_NOT_DEFINE_ERROR;
import static by.it.advertproject.command.ParameterName.*;

public class ImageLoadCommandProvider {

    private static Logger logger = LogManager.getLogger(ImageLoadCommandProvider.class);

    public static ImageLoadCommand defineCommand(RequestContent content)
            throws CommandException {
        logger.log(Level.INFO, "ImageLoadCommandFactory");
        String action = content.getRequestParameters(PARAM_NAME_COMMAND, 0);
        if (action == null || action.isEmpty()) {
            return null;
        }
        ImageLoadCommand imageLoadCommand;
        switch (action) {
            case PARAM_VALUE_POST_IMG:
                imageLoadCommand = new LoadPostImageCommand();
                break;
            case PARAM_VALUE_ACCOUNT_IMG:
                imageLoadCommand = new LoadAccountPhotoCommand();
                break;
            default:
                throw new CommandException(COMMAND_NOT_DEFINE_ERROR);
        }
        return imageLoadCommand;
    }
}
