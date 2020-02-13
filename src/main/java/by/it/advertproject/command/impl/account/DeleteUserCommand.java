package by.it.advertproject.command.impl.account;

import by.it.advertproject.bean.Account;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ALL_ACCOUNT_LIST;
import static by.it.advertproject.command.Message.ACCOUNT_IS_NULL;
import static by.it.advertproject.command.ParameterName.*;

public class DeleteUserCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(DeleteUserCommand.class);

    @Override
    public Router execute(RequestContent content) throws CommandException {
        LOGGER.log(Level.INFO, "DeleteUserCommand.");
        AccountService accountService = new AccountService();
        try {
            long idAccountForDelete = Long.parseLong(content.getRequestParameters(PARAM_ID_USER_FOR_DEL, 0));
            boolean paramMarkIfAdmin = Boolean.parseBoolean(content.getRequestParameters(PARAM_MARK_IF_ADMIN, 0));
            accountService.deleteAccount(idAccountForDelete);
            if (paramMarkIfAdmin) {
                String page = CommandUrlBuilder.TO_ADMIN_PROFILE_PAGE.getUrl();
                List<Account> allAccount = accountService.findAllAccount();
                content.putSessionAttribute(ATTR_NAME_ALL_ACCOUNT_LIST, allAccount);
                return new Router(page, TransmissionType.FORWARD);
            } else {
                content.invalidateSession();
                String page = CommandUrlBuilder.TO_MAIN_PAGE.getUrl();
                return new Router(page, TransmissionType.FORWARD);
            }
        } catch (ServiceException e) {
            if (e.getMessage().equals(ACCOUNT_IS_NULL)) {
                String page = CommandUrlBuilder.TO_ADMIN_PROFILE_PAGE.getUrl();
                return new Router(page, TransmissionType.FORWARD);
            }
            LOGGER.log(Level.WARN, "DeleteUserCommand." + e);
            throw new CommandException(e.getMessage());
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "DeleteUserCommand." + e);
            throw new CommandException(e);
        }
    }
}
