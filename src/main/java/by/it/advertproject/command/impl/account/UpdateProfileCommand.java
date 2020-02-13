package by.it.advertproject.command.impl.account;

import by.it.advertproject.bean.Account;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.Message.SUCCESS_UPDATE_MESSAGE;
import static by.it.advertproject.command.Message.SUCCESS_UPDATE_USER_PROFILE_DATA;
import static by.it.advertproject.command.ParameterName.*;

public class UpdateProfileCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UpdatePhotoCommand.class);

    @Override
    public Router execute(RequestContent content) {
        long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
        String page;
        String name = content.getRequestParameters(PARAM_NAME, 0);
        String password = content.getRequestParameters(PARAM_PASSWORD, 0);
        String confirm = content.getRequestParameters(PARAM_PASSWORD_CONFIRM, 0);
        String email = content.getRequestParameters(PARAM_EMAIL, 0);
        String tel = content.getRequestParameters(PARAM_TEL, 0);
        AccountService accountService = new AccountService();
        try {
            Account account = accountService.updateProfileData(accountId, name, password, confirm, email, tel);
            content.putSessionAttribute(ATTR_NAME_USER, account.getName());
            content.putSessionAttribute(ATTR_NAME_TELEPHONE, account.getTel());
            content.putSessionAttribute(ATTR_NAME_EMAIL, account.getEmail());
            page = CommandUrlBuilder.TO_EDIT_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, MessageManager.getProperty(SUCCESS_UPDATE_MESSAGE,
                            String.valueOf(content.getSessionAttribute(ATTR_NAME_LANG))))
                    .getUrl();
            content.putRequestAttribute(ATTR_NAME_SUCCESS_UPDATE_PROFILE_DATA,
                    MessageManager.getProperty(SUCCESS_UPDATE_USER_PROFILE_DATA,
                            String.valueOf(content.getSessionAttribute(ATTR_NAME_LANG))));
        } catch (ServiceException e) {
            page = CommandUrlBuilder.TO_EDIT_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, e.getMessage())
                    .getUrl();
            content.putRequestAttribute(ATTR_NAME_FB, MessageManager.getProperty(e.getMessage(),
                    String.valueOf(content.getSessionAttribute(ATTR_NAME_LANG))));
        }
        return new Router(page, TransmissionType.FORWARD);
    }
}
