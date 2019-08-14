//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Account;
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.controller.Form;
//import by.it.databasetask.controller.Tools;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import by.it.advertproject.bean.Advert;
//import by.it.databasetask.dao.Dao;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class CommandCreateAdvert implements Command {
//    private static final Logger logger = LogManager.getRootLogger();
//
//    @Override
//    public Action execute(HttpServletRequest req) throws CommandException, SQLException {
//        if (!Tools.checkUser(req))
//            return Action.SIGN_IN;
//
//        if (Form.isPost(req)) {
//            String title = Form.getString(req, "title", "[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\\-!?,. ]{7,49}");
//            String description = Form.getString(req, "description", "[a-zа-яA-Z-А-Я0-9.,?!\\- ]{7,2000}");
//            String brnd = Form.getString(req, "brnd", "[a-zA-Zа-яА-Я0-9- ]{1,45}");
//            String model = Form.getString(req, "model", "[a-zA-Zа-яА-Я0-9 ]{1,45}");
//            String color = Form.getString(req, "color", "[a-zA-Zа-яА-Я- ]{1,45}");
//            String body = Form.getString(req, "body", "[a-zA-Zа-яА-Я]{1,45}");
//            int year = Form.getInteger(req, "year");
//            double engine = Form.getDouble(req, "engine");
//            String at = Form.getString(req, "at");
//            String driveunit = Form.getString(req, "driveunit", "[a-zA-Zа-яА-Я0-9()]{1,45}");
//            String equipment = Form.getString(req, "equipment", "[a-zA-Zа-яА-Я]{1,45}");
//            int millage = Form.getInteger(req, "millage");
//            String crashed = Form.getString(req, "crashed");
//            double price = Form.getDouble(req, "price");
//            Account account = Tools.findUser(req);
//            Advert advert = new Advert( title, description, brnd, model, color, body, year, engine, at, driveunit, equipment, millage, crashed, price, account.getId());
//            Dao dao = Dao.getDao();
//            if (dao.ad.create(advert)) {
//                try {
//                    Tools.saveFile(req, "advert" + advert.getId());
//                } catch (IOException e) {
//                    logger.log(Level.ERROR, e);
//                } catch (ServletException e) {
//                    logger.log(Level.ERROR, e);
//                }
//                req.getSession().setAttribute("advert", advert);
//            }
////            Tools.sendGet(brnd, model, year, price);
//            return Action.PROFILE;
//        }
//        return Action.CREATEAD;
//    }
//}
