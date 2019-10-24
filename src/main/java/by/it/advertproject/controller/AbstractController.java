package by.it.advertproject.controller;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static by.it.advertproject.command.ParameterName.PARAM_NAME_ERROR_MESSAGE;

public abstract class AbstractController extends HttpServlet {
    private static Logger logger = LogManager.getLogger(AbstractController.class);

    //    private static final String COMMAND = "command";
//    private static final String INDEX = "../index.jsp";
private final Logger LOGGER = LogManager.getRootLogger();
    protected void process(HttpServletRequest request, HttpServletResponse response,
                           RequestContent content) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try {
            content.extractValues(request);
            Command command = CommandFactory.defineCommand(content);
            Router router;
            router = command.execute(content);
            content.insertAttributes(request);
            if (router.getTransmissionType().equals(TransmissionType.FORWARD)) {
                logger.log(Level.INFO, "from AbstractController. if block. ");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getPath());
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + router.getPath());
            }
        } catch (CommandException e) {
            logger.log(Level.INFO, "from AbstractController. Catch block. \n e.getMessage(): " + e.getMessage());

            response.sendRedirect(CommandUrlBuilder.TO_ERROR
                    .setParams(PARAM_NAME_ERROR_MESSAGE, e.getMessage())
                    .getUrl());
        }
    }
}
//
////        ActionFactory client = new ActionFactory();
////        ActionCommand command = client.defineCommand(request);
//
//        System.out.print("+++++++++++++++++++++++\n command = " + request.getParameter("command") + "\n");
//                // определение команды, пришедшей из JSP
//                Command command = CommandFactory.defineCommand(request.getParameter(COMMAND));
//                /*
//                 * вызов реализованного метода execute() и передача параметров
//                 * классу-обработчику конкретной команды
//                 */
//                page = command.execute(request);
//                System.out.println("from AbstractController. page: "+page);
//// метод возвращает страницу ответа
//// page = null; // поэксперементировать!
//                if (page != null) {
//                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//// вызов страницы ответа на запрос
//                dispatcher.forward(request, response);
//                } else {
//// установка страницы c cообщением об ошибке
////            page = ConfigurationManager.getProperty("path.page.index");
//                page = INDEX;
////            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
//                request.getSession().setAttribute("nullPage", "message nullpage");
//                response.sendRedirect(request.getContextPath() + page);
//                }
