//package by.it.databasetask.controller;
//
//import by.it.advertproject.command.*;
//import by.it.databasetask.command.*;
//import by.it.databasetask.command.Command;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//
//public enum Action {
//
//    RESET(new CommandReset()),
//    EDITUSERS(new CommandEditUsers()),
////    EDITADS(new CommandEditAds()),
//    INDEX(new CommandIndex()),
//    SIGN_IN(new CommandLogin()),              //+
////    SEARCHRESULT(new CommandSearchResult()),
////    PROFILE(new CommandProfile()),
//    SIGNUP(new CommandSignUp()),
//    ERROR(new CommandError()),
////    CREATEAD(new CommandCreateAdvert());
//
//    public Command command;
// //    private Command command;
//    private static final Logger logger = LogManager.getRootLogger();
//
//    private static final String COMMAND_PARAMETER = "command";
//
//    Action(Command commandIndex) {
//        command = commandIndex;
//    }
//
//    static Action define(HttpServletRequest req) {
//        Action result = Action.INDEX;
//        String command = req.getParameter(COMMAND_PARAMETER);
//        if (command != null && !command.isEmpty()) {
//            try {
//                result = Action.valueOf(command.toUpperCase());
//            } catch (IllegalArgumentException e) {
//                //create error
//                logger.log(Level.ERROR, e);
//            }
//        }
//        return result;
//    }
//
//    String getJsp() {
//        return "/" + this.name().toLowerCase() + ".jsp";
//    }
//
//}
//
