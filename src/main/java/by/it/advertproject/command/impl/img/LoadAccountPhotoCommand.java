package by.it.advertproject.command.impl.img;


import by.it.advertproject.bean.Account;
import by.it.advertproject.command.ImageLoadCommand;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;

import java.io.IOException;

import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_ACCOUNT_ID;


public class LoadAccountPhotoCommand implements ImageLoadCommand {
    private static final String DEFAULT_PHOTO_PATH = "/images/img-01.png";

    @Override
    public byte[] load(RequestContent requestContent) throws CommandException {
        Account account;
        AccountService accountService = new AccountService();
        byte[] photo;

        long accountId = Long.parseLong(requestContent
                .getRequestParameters(PARAM_NAME_ACCOUNT_ID, 0));
        try {
            account = accountService.findAccount(accountId);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        photo = account.getPhoto();
        if (photo.length == 0) {
            try {
                photo = requestContent.getContext()
                        .getResourceAsStream(DEFAULT_PHOTO_PATH).readAllBytes();
            } catch (IOException e) {
                throw new CommandException(LOAD_FILE_ERROR_MESSAGE);
            }
        }
        return photo;
    }

}
