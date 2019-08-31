package by.it.advertproject.controller;

import by.it.advertproject.command.RequestContent;
import by.it.advertproject.connectionpool.ConnectionPool;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/controller", "*.do"})

public class FrontController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp, new RequestContent());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp, new RequestContent());
    }

    @Override
    public void destroy() {
        ConnectionPool.INSTANCE.destroyPool();
//        super.destroy();
    }
}
