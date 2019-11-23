package by.it.advertproject.command.impl.img;


import by.it.advertproject.bean.Account;
import by.it.advertproject.command.ImageLoadCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.impl.SignInCommand;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCOUNT_ID;
import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_ACCOUNT_ID;


public class LoadAccountPhotoCommand implements ImageLoadCommand {
    private static Logger logger = LogManager.getLogger(SignInCommand.class);
    private static final String DEFAULT_PHOTO_PATH = "/images/img-01.png";
    @Override
    public byte[] load(RequestContent requestContent) throws CommandException {
        logger.log(Level.INFO, "from LoadAccountPhotoCommand.");
        logger.log(Level.INFO, "from LoadAccountPhotoCommand. load method");
        Account account;
        logger.log(Level.INFO, "from LoadAccountPhotoCommand. create account service");

        AccountService accountService = new AccountService();
        logger.log(Level.INFO, "from LoadAccountPhotoCommand. create byte[] photo");

        byte[] photo;
        logger.log(Level.INFO, "from LoadAccountPhotoCommand. equestContent.getRequestParameters(PARAM_NAME_ACCOUNT_ID, 0) " + PARAM_NAME_ACCOUNT_ID);
        long accountId = Long.parseLong(requestContent.getRequestParameters(PARAM_NAME_ACCOUNT_ID, 0));


        logger.log(Level.INFO, "from LoadAccountPhotoCommand. long accountId = " + accountId);

        try {
            logger.log(Level.INFO, "from LoadAccountPhotoCommand. try block ");

            account = accountService.findAccount(accountId);
            logger.log(Level.INFO, "from LoadAccountPhotoCommand. account = " + account.toString());

        } catch (ServiceException e) {
            logger.log(Level.INFO, "from LoadAccountPhotoCommand. catch block. ServiceException e.getMessage: " + e.getMessage());

            throw new CommandException(e.getMessage());
        }

        photo = account.getPhoto();
        logger.log(Level.INFO, "from LoadAccountPhotoCommand. photo: " + photo.length);

        if (photo.length == 0) {
            try {
                logger.log(Level.INFO, "from LoadAccountPhotoCommand. photo.length == 0");

                photo = requestContent.getContext().getResourceAsStream(DEFAULT_PHOTO_PATH).readAllBytes();
                logger.log(Level.INFO, "from LoadAccountPhotoCommand. photo = requestContent.getContext().getResourceAsStream(DEFAULT_PHOTO_PATH).readAllBytes()");

            } catch (IOException e) {
                logger.log(Level.INFO, "from LoadAccountPhotoCommand. (IOException e.getMessage: " + e.getMessage());

                throw new CommandException(LOAD_FILE_ERROR_MESSAGE);
            }
        }
        return photo;
    }
}
