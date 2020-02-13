package by.it.advertproject.command.impl.img;

import by.it.advertproject.command.ImageLoadCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadPostImageCommand implements ImageLoadCommand {
    private static final Logger logger = LogManager.getLogger(LoadPostImageCommand.class);
    private static final String NOT_FOUND = "Image not found.";

    @Override
    public byte[] load(RequestContent requestContent) throws CommandException {
//        long postId = Long.parseLong(requestContent
//                .getRequestParameters(PARAM_NAME_POST_ID, 0));
//        Post post;
//        try {
//            post = PostLogic.findPost(postId);
//
//        } catch (ServiceException e) {
//            logger.log(Level.WARN, NOT_FOUND);
//            throw new CommandException(LOAD_FILE_ERROR_MESSAGE);
//        }
//        return post.getPhoto();
        return null;
    }
}
