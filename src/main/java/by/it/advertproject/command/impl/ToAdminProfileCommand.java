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

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.PARAM_NAME_PAGE_ID;

public class ToAdminProfileCommand implements Command {
    private static org.apache.logging.log4j.Logger Logger = LogManager.getRootLogger();

    private static final String MAIN_PAGE = "path.page.main";
    private static final String USER_PROFILE_PAGE = "path.page.userprofile";
    private static final String SUBSCRIBE_LABEL = "label.subscribe";
    private static final String UNSUBSCRIBE_LABEL = "label.unsubscribe";
    private static final String REMOVE_ADMIN_LABEL = "label.remove-admin";
    private static final String GIVE_ADMIN_LABEL = "label.give-admin";

    @Override
    public Router execute(RequestContent content) throws CommandException {
        Logger.log(Level.INFO, "from ToAdminProfileCommand.");

//        String page = ConfigurationManager.getProperty(USER_PROFILE_PAGE);
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. page: " +
//                ConfigurationManager.getProperty(USER_PROFILE_PAGE));
//
//        TransmissionType transmissionType = TransmissionType.FORWARD;
//        String lang = (String) content.getSessionAttribute(ATTR_NAME_LANG);
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. lang: " + lang);
//        long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. accountId: " + accountId);
//        String login = (String) content.getSessionAttribute(ATTR_NAME_LOGIN);
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. login: " + login);
//        Role role = (Role) content.getSessionAttribute(ATTR_NAME_ACCESS_LEVEL);
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. role: " + role);
//        long pageId = Long.parseLong(content.getRequestParameters(PARAM_NAME_PAGE_ID, 0));
//        Logger.log(Level.INFO, "from ToAdminProfileCommand. pageId: " + pageId);
//        AccountService accountService = null;
//        try {
//            Logger.log(Level.INFO, "from ToAdminProfileCommand. try");
//            Account account = accountService.findAccount(pageId);
//            Logger.log(Level.INFO, "from ToUserProfileCommand. account: " + account);
////            List<Post> posts = PostLogic.findPostsByAuthor(pageId);
//            content.putRequestAttribute(ATTR_NAME_USER, login);
////            content.putRequestAttribute(ATTR_NAME_POSTS, posts);
//            content.putRequestAttribute(ATTR_NAME_ACCOUNT, account);
//            if (role.equals(Role.ADMINISTRATOR)) {
//                if (account.getRole().equals(Role.ADMINISTRATOR)) {
//                    String removeAdminLabel = MessageManager.getProperty(REMOVE_ADMIN_LABEL, lang);
//                    content.putRequestAttribute(ATTR_NAME_GIVE_ADMIN_LEVEL, removeAdminLabel);
//                } else {
//                    String giveAdminLabel = MessageManager.getProperty(GIVE_ADMIN_LABEL, lang);
//                    content.putRequestAttribute(ATTR_NAME_GIVE_ADMIN_LEVEL, giveAdminLabel);
//                }
//            }
////            if (accountService.isSubscribe(accountId, pageId)) {
////                String unsubscribeLabel = MessageManager.getProperty(UNSUBSCRIBE_LABEL, lang);
////                content.putRequestAttribute(ATTR_NAME_SUBSCRIPTION, unsubscribeLabel);
////            } else {
////                String subscribeLabel = MessageManager.getProperty(SUBSCRIBE_LABEL, lang);
////                content.putRequestAttribute(ATTR_NAME_SUBSCRIPTION, subscribeLabel);
////            }
//        } catch (ServiceException e) {
//            Logger.log(Level.INFO, "from ToUserProfileCommand. catch block");
//
//            throw new CommandException(e.getMessage());
//        }
//        return new Router(page, transmissionType);


        String page = "/jsppage/adminprofile.jsp";
        Logger.log(Level.INFO, "from ToUserProfileCommand. page: " + page);
        return new Router(page, TransmissionType.FORWARD);

    }
}
