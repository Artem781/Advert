package by.it.advertproject.command.impl.account;


import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCOUNT_ID;
import static by.it.advertproject.command.AttributeName.ATTR_NAME_ERROR_MESSAGE_UPLOAD_IMAGE;
import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;
import static by.it.advertproject.command.Message.UNSUPPORTED_IMAGE_FORMAT_MESSAGE;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;
import static java.util.Locale.ENGLISH;


public class UpdatePhotoCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UpdatePhotoCommand.class);

    private static final String JPG_FORMAT = ".jpg";
    private static final String PNG_FORMAT = ".png";
    private static final String DOT = ".";
    private static final String STRING_NULL = "null";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        String page;
        AccountService accountService = new AccountService();
        boolean mark = false;
        try {
            long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
//            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
//                    .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
//                    .getUrl();
//            logger.log(Level.INFO, "from UpdatePhotoCommand. page = " + page);

            Collection<Part> parts = ((PartsRequestContent) content).getParts();
            logger.log(Level.INFO, "Collection<Part> parts.isEmpty() = " + parts.isEmpty());
            logger.log(Level.INFO, "Collection<Part> parts.size() = " + parts.size());
            logger.log(Level.INFO, "Collection<Part> parts.toString() = " + parts.toString());
            Collection<Part> parts1 = ((PartsRequestContent) content).getParts();

//            for (Part element : parts1) {
//                String submittedFileName = element.getSubmittedFileName();
//                logger.log(Level.INFO, "submittedFileName = " + submittedFileName);
//                String name = element.getName();
//                logger.log(Level.INFO, "name = " + name);
//                String contentType = element.getContentType();
//                logger.log(Level.INFO, "contentType = " + contentType);
//                Collection<String> headerNames = element.getHeaderNames();
//                logger.log(Level.INFO, "element.getHeaderNames().size " + headerNames.size());
//                for (String headerNameElement : headerNames) {
//                    logger.log(Level.INFO, "headerNameElement " + headerNameElement);
//                }
//
//            }
            int count = 0;
            for (Part part : parts) {
                count++;
                logger.log(Level.INFO, "count = " + count);
                String path = part.getSubmittedFileName();
                logger.log(Level.INFO, "String path: = " + path);
                if (path != null && !path.isEmpty()) {
                    logger.log(Level.INFO, "if (path != null) {");
                    String extension = path.substring(path.lastIndexOf(DOT));
                    logger.log(Level.INFO, "String extension = " + extension);
                    if (extension.equalsIgnoreCase(JPG_FORMAT) ||
                            extension.equalsIgnoreCase(PNG_FORMAT)) {
                        InputStream inputStream = part.getInputStream();
                        accountService.updatePhoto(accountId, inputStream.readAllBytes());
                        mark = true;
                    } else {
                        logger.log(Level.INFO, UNSUPPORTED_IMAGE_FORMAT_MESSAGE);
//                        content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE_UPLOAD_IMAGE, UNSUPPORTED_IMAGE_FORMAT_MESSAGE);
//                        return new Router(page, TransmissionType.REDIRECT);
                        throw new CommandException(UNSUPPORTED_IMAGE_FORMAT_MESSAGE);
                    }
                } else {
                    logger.log(Level.INFO, "elseeee");
                }
            }

            logger.log(Level.INFO, "mark: " + mark);
            if (mark) {
                logger.log(Level.INFO, "TO_USER_PROFILE_PAGE: ");

                page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
                        .getUrl();
            } else {
                logger.log(Level.INFO, "TO_EDIT_USER_PROFILE_PAGE: ");
                // TODO: 18.01.2020 почему нельза положить в putRequestAttribute.
//                content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE_UPLOAD_IMAGE, String.valueOf(
//                        UNSUPPORTED_IMAGE_FORMAT_MESSAGE));
                content.putRequestAttribute("exampleAttr","HELLLLLo");

                content.putSessionAttribute(ATTR_NAME_ERROR_MESSAGE_UPLOAD_IMAGE,
                        MessageManager.getProperty(UNSUPPORTED_IMAGE_FORMAT_MESSAGE, String.valueOf(ENGLISH)));
                page = CommandUrlBuilder.TO_EDIT_USER_PROFILE_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
                        .getUrl();
            }
            logger.log(Level.INFO, "from UpdatePhotoCommand. page = " + page);

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
