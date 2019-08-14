//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Advert;
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
//public class CommandEditAds implements Command {
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException, CommandException {
//        if (Tools.checkUser(req)) {
//            Dao dao = Dao.getDao();
//            if (Tools.isAdmin(req)) {
//                if (Form.isPost(req)) {
//                    long id = Form.getLong(req, "id");
//                    String title = Form.getString(req, "title");
//                    String description = Form.getString(req, "description");
//                    String brnd = Form.getString(req, "brnd");
//                    String model = Form.getString(req, "model");
//                    String color = Form.getString(req, "color");
//                    String body = Form.getString(req, "body");
//                    int year = Form.getInteger(req, "year");
//                    double engine = Form.getDouble(req, "engine");
//                    String at = Form.getString(req, "at");
//                    String driveunit = Form.getString(req, "driveunit");
//                    String equipment = Form.getString(req, "equipment");
//                    int millage = Form.getInteger(req, "millage");
//                    String crashed = Form.getString(req, "crashed");
//                    double price = Form.getDouble(req, "price");
//                    long id_User = Form.getLong(req, "id_User");
//                    Advert advert = new Advert( title, description, brnd, model, color, body, year, engine, at, driveunit, equipment, millage, crashed, price, id_User);
//                    if (req.getParameter("delete") != null) {
//                        dao.ad.delete(advert);
//                        Tools.deleteFile(req, "advert" + advert.getId());
//                    }
//                }
//                List<Account> accounts = dao.user.getALL();
//                req.setAttribute("accounts", accounts);
//                List<Advert> adverts = dao.ad.getALL();
//                req.setAttribute("adverts", adverts);
//            } else return Action.INDEX;
//        } else return Action.SIGN_IN;
//        return Action.EDITADS;
//    }
//}
