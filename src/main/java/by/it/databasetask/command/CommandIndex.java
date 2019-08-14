//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Advert;
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.dao.Dao;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CommandIndex implements Command {
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException {
//        List<Advert> adverts = Dao.getDao().ad.getALL();
//        req.setAttribute("adverts", adverts);
//        return null;
//    }
//}
