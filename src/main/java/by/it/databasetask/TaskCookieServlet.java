package by.it.databasetask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/cook")
public class TaskCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("nameCookie", "valueCookie");
        resp.addCookie(cookie);
//        getServletConfig();
        Locale locale = resp.getLocale();
        Cookie loc = new Cookie("LocaleCookie", locale.toString());
        resp.addCookie(loc);
//        String stringLoc= loc.getName();
        String stringLoc= loc.getName() + "-name\t" + loc.getValue() + "-value\t"+ loc.getDomain()+"-domian\t"+
                loc.getPath()+"-path\t"+loc.getMaxAge()+"-maxAge\n";

        List<String> mes = new ArrayList<>();
        Cookie[] masCook = req.getCookies();
        mes.add("length: " + masCook.length);
        for (int i = 0; i <masCook.length ; i++) {
            Cookie c = masCook[i];
//            mes.add(c.getName() + "-name\t" + c.getValue() + "-value\t"+ c.getDomain()+"-domian\t"+
//                    c.getPath()+"-path\t"+c.getMaxAge()+"-maxAge\n");
            mes.add(c.getName() + "-name\t" + c.getValue() + "-value\t");

        }
        req.setAttribute("messages", mes);
        req.setAttribute("stringLoc", stringLoc);
        req.getRequestDispatcher("/jsp/cookie.jsp").forward(req,resp);
    }
}
