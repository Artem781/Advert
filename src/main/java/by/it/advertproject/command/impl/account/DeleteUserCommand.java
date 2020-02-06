package by.it.advertproject.command.impl.account;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.ParameterName.*;

public class DeleteUserCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteUserCommand.class);

    @Override
    public Router execute(RequestContent content) throws CommandException {
        logger.log(Level.INFO, "from DeleteUserCommand. ");
//        long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
//        logger.log(Level.INFO, "from DeleteUserCommand. accountId: " + accountId);
//        String idAccountForDelete = content.getRequestParameters(ID_USER_FOR_DEL, 0);

        AccountService accountService = new AccountService();
        try {
            long idAccountForDelete = Long.parseLong(content.getRequestParameters(PARAM_ID_USER_FOR_DEL, 0));
            logger.log(Level.INFO, "from DeleteUserCommand. idAccountForDelete: " + idAccountForDelete);
            boolean paramMarkIfAdmin = Boolean.parseBoolean(content.getRequestParameters(PARAM_MARK_IF_ADMIN, 0));
            logger.log(Level.INFO, "from DeleteUserCommand. paramMarkIfAdmin: " + paramMarkIfAdmin);
            accountService.deleteAccount(idAccountForDelete);
            if (paramMarkIfAdmin) {
                String page = CommandUrlBuilder.TO_ADMIN_PROFILE_PAGE.getUrl();
                logger.log(Level.INFO, "from DeleteUserCommand. TO_ADMIN_PROFILE_PAGE");
                logger.log(Level.INFO, "from DeleteUserCommand. ///////////////////////////////////////////////////////");
                return new Router(page, TransmissionType.FORWARD);
            } else {
                content.invalidateSession();
                String page = CommandUrlBuilder.TO_MAIN_PAGE.getUrl();
                logger.log(Level.INFO, "from DeleteUserCommand. TO_MAIN_PAGE");
                return new Router(page, TransmissionType.FORWARD);
            }
        } catch (ServiceException e) {
            logger.log(Level.INFO, "from DeleteUserCommand. e.getMessage: " + e.getMessage());
            logger.log(Level.WARN, e.getMessage());
            throw new CommandException(e.getMessage());
        }
    }
}
