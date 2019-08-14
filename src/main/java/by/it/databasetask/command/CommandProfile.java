//package by.it.databasetask.command;
//
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.controller.Form;
//import by.it.databasetask.controller.Tools;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import by.it.advertproject.bean.Advert;
//import by.it.advertproject.bean.Account;
//import by.it.databasetask.dao.Dao;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CommandProfile implements Command {
//    private static final Logger logger = LogManager.getRootLogger();
//
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException, CommandException {
//        if (!Tools.checkUser(req))
//            return Action.SIGN_IN;
//        Dao dao = Dao.getDao();
////        if (Form.isPost(req)) {
////            if (Form.getString(req, "logout") != null) {
////                req.getSession().invalidate();
////                return Action.SIGN_IN;
////            }
////        }
//        if (Form.isPost(req)) {
//            if (Form.getString(req, "logout") != null) {
//                req.getSession().invalidate();
//                return Action.SIGN_IN;
//            }
//            long id = (long) Form.getLong(req, "id");
//            String title = Form.getString(req, "title");
//            String description = Form.getString(req, "description");
//            String brnd = Form.getString(req, "brnd");
//            String model = Form.getString(req, "model");
//            String color = Form.getString(req, "color");
//            String body = Form.getString(req, "body");
//            int year = (int) Form.getInteger(req, "year");
//            double engine = (double) Form.getDouble(req, "engine");
//            String at = Form.getString(req, "at");
//            String driveunit = Form.getString(req, "driveunit");
//            String equipment = Form.getString(req, "equipment");
//            int millage = Form.getInteger(req, "millage");
//            String crashed = Form.getString(req, "crashed");
//            double price = Form.getDouble(req, "price");
//            long id_User = Form.getLong(req, "id_User");
//            Advert advert = new Advert( title, description, brnd, model, color, body, year, engine, at, driveunit, equipment, millage, crashed, price, id_User);
//            if (req.getParameter("delete") != null)
//                if (dao.ad.delete(advert))
//                    Tools.deleteFile(req, "advert" + advert.getId());
//
//            if (req.getParameter("update") != null) {
//                if (dao.ad.update(advert)) {
//                    try {
//                        Tools.saveFile(req, "advert" + advert.getId());
//                    } catch (IOException e) {
//                        logger.log(Level.ERROR, e);
//                    } catch (ServletException e) {
//                        logger.log(Level.ERROR, e);
//                    }
//                }
//            }
//        }
//        Account account = (Account) Tools.findUser(req);
//        String where = String.format(" WHERE `users_id`='%d'", account.getId());
//
//        List<Advert> adverts = Dao.getDao().ad.getAll(where);
//        req.setAttribute("adverts", adverts);
//
//        return Action.PROFILE;
//    }
//}