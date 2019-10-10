package by.it.advertproject.tester;

import by.it.advertproject.command.impl.SetLanguageCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SetLanguageCommandTester {
    private static final Logger logger = LogManager.getLogger(SetLanguageCommand.class);

    public static void main(String[] args) {

        SetLanguageCommand setLanguageCommand = new SetLanguageCommand();
        String nextPage = "TO_SIGN_IN";

        String page = null;

        switch (nextPage) {
//            case LOGIN:
//                page = ConfigurationManager.getProperty(LOGIN_PAGE);
//                break;
//            case TO_SIGN_IN:
////                page = ConfigurationManager.getProperty(SIGN_IN_PAGE);
//                logger.log(Level.INFO, "case TO_SIGN_IN: \n \t\t page = " + page);
//
//                break;
//            case SETTING:
//                long accountId = (long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
//                try {
//                    Account account = service.findAccount(accountId);
//                    content.putRequestAttribute(ATTR_NAME_ACCOUNT, account);
//                    String feedbackType = content.getRequestParameters(PARAM_NAME_FEEDBACK, 0);
//                    if (feedbackType == null || feedbackType.isEmpty()) {
//                        content.putRequestAttribute(ATTR_LOGIN_ERROR, EMPTY_STRING);
//                    } else {
//                        String error = MessageManager.getProperty(feedbackType, lang);
//                        content.putRequestAttribute(ATTR_LOGIN_ERROR, error);
//                    }
//                } catch (ServiceException e) {
//                    throw new CommandException(e.getMessage());
//                }
//                page = ConfigurationManager.getProperty(SETTING_PAGE);
//
//                break;
//            case REGISTRATION:
//                page = ConfigurationManager.getProperty(REGISTRATION_PAGE);
//                break;

            default:
                logger.log(Level.INFO, "from default");

//                throw new CommandException(NEXT_PAGE_EXCEPTION);
        }
    }
}
