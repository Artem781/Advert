//package by.it.databasetask.controller;
//
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class FrontController extends HttpServlet {
//    private static final Logger logger = LogManager.getRootLogger();
//
////    @Override
////    public void init() throws ServletException {
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
//////            List<Role> roles = Dao.getDao().role.getALL();
//////            getServletContext().setAttribute("roles", roles);
////        } catch (ClassNotFoundException | SQLException e) {
////            logger.log(Level.ERROR, e);
////        }
////    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                process(req, resp);
////        resp.setContentType("text/html");
//
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Action action = Action.define(req);
//        Action next = null;
//        try {
//            try {
//                next = action.command.execute(req);
//            } catch (SQLException e) {
//                logger.log(Level.ERROR, e);
//            }
//
//        } catch (CommandException e) {
//            StringBuilder message = new StringBuilder(e.toString());
//            message.append("<p>");
//            for (StackTraceElement element : e.getStackTrace()) {
//                if (element.getClass().getName().contains("HttpServlet"))
//                    break;
//                message.append(element.toString()).append("<br>");
//            }
//            req.setAttribute("message", message);
//            toJsp(req, resp, Action.ERROR.getJsp());
//        }
//
//
//        if (next == null || next == action) {
//            toJsp(req, resp, action.getJsp());
//        } else resp.sendRedirect("do?command=" + next.toString().toLowerCase());
//    }
//
//    private void toJsp(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
//        ServletContext servletContext = req.getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jsp);
//        requestDispatcher.forward(req, resp);
//    }
//}
