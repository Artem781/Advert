package by.it.advertproject.command.impl.account;


import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCOUNT_ID;
import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;
import static by.it.advertproject.command.Message.UNSUPPORTED_IMAGE_FORMAT_MESSAGE;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;


public class UpdatePhotoCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UpdatePhotoCommand.class);

    private static final String JPG_FORMAT = ".jpg";
    private static final String PNG_FORMAT = ".png";
    private static final String DOT = ".";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        String page;
        AccountService accountService = new AccountService();
        try {
            long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
            page = CommandUrlBuilder.TO_PERSONAL_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
                    .getUrl();
            logger.log(Level.INFO, "from UpdatePhotoCommand. page = " + page);

            Collection<Part> parts = ((PartsRequestContent) content).getParts();
            logger.log(Level.INFO, "Collection<Part> parts.isEmpty() = " + parts.isEmpty());
            logger.log(Level.INFO, "Collection<Part> parts.size() = " + parts.size());
            logger.log(Level.INFO, "Collection<Part> parts.toString() = " + parts.toString());

            for (Part part : parts) {
                String path = part.getSubmittedFileName();
                logger.log(Level.INFO, "String path = " + path);
                if (path != null) {
                    String extension = path.substring(path.lastIndexOf(DOT));
                    logger.log(Level.INFO, "String extension = " + extension);
                    if (extension.equalsIgnoreCase(JPG_FORMAT) ||
                            extension.equalsIgnoreCase(PNG_FORMAT)) {
                        InputStream inputStream = part.getInputStream();
                        accountService.updatePhoto(accountId, inputStream.readAllBytes());

                    } else {
                        throw new CommandException(UNSUPPORTED_IMAGE_FORMAT_MESSAGE);
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "from UpdatePhotoCommand. catch block. IOException. e.getMessage: " + e.getMessage());
            throw new CommandException(LOAD_FILE_ERROR_MESSAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "from UpdatePhotoCommand. catch block. ServiceException. e.getMessage: " + e.getMessage());
            throw new CommandException(e.getMessage());
        }
        return new Router(page, TransmissionType.REDIRECT);
    }
}
