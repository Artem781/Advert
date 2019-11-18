package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Role;
import by.it.advertproject.command.Command;
import by.it.advertproject.command.RequestContent;
import by.it.advertproject.command.Router;
import by.it.advertproject.command.TransmissionType;
import by.it.advertproject.exception.CommandException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.util.ConfigurationManager;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;

public class ToMainCommand implements Command {

    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    private static final String MAIN_PAGE = "path.page.main";
    private static final String SUBSCRIBE_LABEL = "label.subscribe";
    private static final String UNSUBSCRIBE_LABEL = "label.unsubscribe";
    private static final String REMOVE_ADMIN_LABEL = "label.remove-admin";
    private static final String GIVE_ADMIN_LABEL = "label.give-admin";
    @Override
    public Router execute(RequestContent content) throws CommandException {

        String page = ConfigurationManager.getProperty(MAIN_PAGE);
        TransmissionType transmissionType = TransmissionType.FORWARD;
        String lang = (String) content.getSessionAttribute(ATTR_NAME_LANG);
        long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
        String login = (String) content.getSessionAttribute(ATTR_NAME_LOGIN);
        Role role = (Role) content.getSessionAttribute(ATTR_NAME_ACCESS_LEVEL);
        long pageId = Long.parseLong(content.getRequestParameters(PARAM_NAME_PAGE_ID, 0));
        AccountService accountService = null;
        try {

            Account account = accountService.findAccount(pageId);
//            List<Post> posts = PostLogic.findPostsByAuthor(pageId);
            content.putRequestAttribute(ATTR_NAME_USER, login);
//            content.putRequestAttribute(ATTR_NAME_POSTS, posts);
            content.putRequestAttribute(ATTR_NAME_ACCOUNT, account);
            if (role.equals(Role.ADMINISTRATOR)) {
                if (account.getRole().equals(Role.ADMINISTRATOR)) {
                    String removeAdminLabel = MessageManager.getProperty(REMOVE_ADMIN_LABEL, lang);
                    content.putRequestAttribute(ATTR_NAME_GIVE_ADMIN_LEVEL, removeAdminLabel);
                } else {
                    String giveAdminLabel = MessageManager.getProperty(GIVE_ADMIN_LABEL, lang);
                    content.putRequestAttribute(ATTR_NAME_GIVE_ADMIN_LEVEL, giveAdminLabel);
                }
            }
//            if (accountService.isSubscribe(accountId, pageId)) {
//                String unsubscribeLabel = MessageManager.getProperty(UNSUBSCRIBE_LABEL, lang);
//                content.putRequestAttribute(ATTR_NAME_SUBSCRIPTION, unsubscribeLabel);
//            } else {
//                String subscribeLabel = MessageManager.getProperty(SUBSCRIBE_LABEL, lang);
//                content.putRequestAttribute(ATTR_NAME_SUBSCRIPTION, subscribeLabel);
//            }
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        return new Router(page, transmissionType);


//        String page = "/jsppage/main.jsp";
//        Logger.log(Level.INFO, "from ToMainCommand. page: " + page);
//        return new Router(page, TransmissionType.FORWARD);
    }
}
