//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Account;
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.controller.Form;
//import by.it.databasetask.dao.Dao;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CommandLogin implements Command {
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException, CommandException {
//        if (Form.isPost(req)) {
//            String login = Form.getString(req, "login","[a-zA-Z][a-zA-Z0-9_]{3,44}");
//            String password = Form.getString(req, "password", "[a-zA-Z][a-zA-Z0-9_^]{4,25}");
//            String where = String.format(" WHERE login='%s' and password='%s' LIMIT 0,1", login, password);
//            List<Account> accounts = Dao.getDao().user.getAll(where);
//            if (accounts.size() == 1) {
//                Account account = accounts.get(0);
//                req.getSession().setAttribute("account", account);
//                return Action.PROFILE;
//            }
//        }
//        return Action.SIGN_IN;
//    }
//}
