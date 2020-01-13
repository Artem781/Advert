package by.it.advertproject.command.impl.account;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.AttributeName.ATTR_NAME_EMAIL;
import static by.it.advertproject.command.Message.SUCCESS_UPDATE_MESSAGE;
import static by.it.advertproject.command.ParameterName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_FEEDBACK;

public class DeleteUserCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteUserCommand.class);

    @Override
    public Router execute(RequestContent content) throws CommandException {
        logger.log(Level.INFO, "from DeleteUserCommand. ");
        long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
        logger.log(Level.INFO, "from DeleteUserCommand. accountId: " + accountId);
        AccountService accountService = new AccountService();
        try {
            logger.log(Level.INFO, "from DeleteUserCommand. try accountService.deleteAccount(accountId);");
            accountService.deleteAccount(accountId);
            content.invalidateSession();
            String page = CommandUrlBuilder.TO_PERSONAL_PAGE.getUrl();
            return new Router(page, TransmissionType.FORWARD);
        } catch (ServiceException e) {
            logger.log(Level.INFO, "from DeleteUserCommand. e.getMessage: " + e.getMessage());
            logger.log(Level.WARN, e.getMessage());
            throw new CommandException(e.getMessage());
        }
    }
}
