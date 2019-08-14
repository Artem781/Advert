//package by.it.databasetask.command;
//
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.dao.Dao;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//
//public class CommandReset implements Command {
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException {
//        Dao.restoreDB();
//        return Action.INDEX;
//    }
//}
