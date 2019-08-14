package by.it.advertproject.controller;

import by.it.advertproject.command.Command;
import by.it.advertproject.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public abstract class AbstractController extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String INDEX = "../index.jsp";

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = null;
// определение команды, пришедшей из JSP
//        ActionFactory client = new ActionFactory();
//        ActionCommand command = client.defineCommand(request);

        System.out.print("+++++++++++++++++++++++\n command = " + request.getParameter("command") + "\n");
        Command command = CommandFactory.defineCommand(request.getParameter(COMMAND));
        /*
         * вызов реализованного метода execute() и передача параметров
         * классу-обработчику конкретной команды
         */
        page = command.execute(request);
        System.out.println("from AbstractController. page: "+page);
// метод возвращает страницу ответа
// page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
// вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        } else {
// установка страницы c cообщением об ошибке
//            page = ConfigurationManager.getProperty("path.page.index");
            page = INDEX;
//            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            request.getSession().setAttribute("nullPage", "message nullpage");
            response.sendRedirect(request.getContextPath() + page);
        }

    }
}
