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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;
import static by.it.advertproject.command.Message.UNSUPPORTED_IMAGE_FORMAT_MESSAGE;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;
import static java.util.Locale.ENGLISH;


public class UpdatePhotoCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UpdatePhotoCommand.class);
    private static final String PATTERN_IMG_FILE = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
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
            Collection<Part> parts = ((PartsRequestContent) content).getParts();
            int count = 0;
            for (Part part : parts) {
                count++;
                String path = part.getSubmittedFileName();
                if (path != null && !path.isEmpty()) {
                    Pattern pattern = Pattern.compile(PATTERN_IMG_FILE);
                    Matcher matcher = pattern.matcher(path);
                    if (matcher.matches()) {
                        InputStream inputStream = part.getInputStream();
                        accountService.updatePhoto(accountId, inputStream.readAllBytes());
                        mark = true;
                    }
                }
            }
            if (mark) {
                page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
                        .getUrl();
            } else {
                content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE_UPLOAD_IMAGE,
                        MessageManager.getProperty(UNSUPPORTED_IMAGE_FORMAT_MESSAGE,
                                String.valueOf(content.getSessionAttribute(ATTR_NAME_LANG))));
                page = CommandUrlBuilder.TO_EDIT_USER_PROFILE_PAGE
                        .setParams(PARAM_NAME_PAGE_ID, String.valueOf(accountId))
                        .getUrl();
            }
        } catch (IOException e) {
            throw new CommandException(LOAD_FILE_ERROR_MESSAGE);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        return new Router(page, TransmissionType.FORWARD);
    }
}
