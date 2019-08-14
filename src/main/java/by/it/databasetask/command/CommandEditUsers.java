//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Account;
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.controller.Form;
//import by.it.databasetask.controller.Tools;
//import by.it.databasetask.dao.Dao;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CommandEditUsers implements Command {
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException, CommandException {
//        if (Tools.checkUser(req)) {
//            Dao dao = Dao.getDao();
//            if (Tools.isAdmin(req)) {
//                if (Form.isPost(req)) {
//                    long id = Form.getLong(req, "id");
//                    String login = Form.getString(req, "login");
//                    String password = Form.getString(req, "password");
//                    String name = Form.getString(req, "name");
//                    String dateOfBirth = Form.getString(req, "dateofbirth");
//                    String email = Form.getString(req, "email");
//                    String tel = Form.getString(req, "tel");
//                    long roles_Id = Form.getLong(req, "roles_Id");
////                    Account account = new Account( name, login, password, dateOfBirth, email, tel, roles_Id);
////                    if (req.getParameter("Update") != null)
////                        dao.user.update(account);
////                    if (req.getParameter("Delete") != null)
////                        dao.user.delete(account);
//                }
//                List<Account> accounts = dao.user.getALL();
//                req.setAttribute("accounts", accounts);
//            } else return Action.INDEX;
//        } else return Action.SIGN_IN;
//
//        return Action.EDITUSERS;
//    }
//}
