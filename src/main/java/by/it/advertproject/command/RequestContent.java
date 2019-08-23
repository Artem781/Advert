package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;

public class RequestContent {

    private HttpSession session;
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public RequestContent() {
        requestParameters = new HashMap<>();
        requestAttributes = new HashMap<>();
        sessionAttributes = new HashMap<>();
    }

    public void extractValues(HttpServletRequest request) throws CommandException {

        Enumeration<String> attrNames = request.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            String name = attrNames.nextElement();
            Object attr = request.getAttribute(name);
            requestAttributes.put(name, attr);
        }
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String[] param = request.getParameterValues(name);
            requestParameters.put(name, param);
        }
        Enumeration<String> sessionAttrNames = request.getSession().getAttributeNames();
        while (sessionAttrNames.hasMoreElements()) {
            String name = sessionAttrNames.nextElement();
            Object sessionAttr = request.getSession().getAttribute(name);
            sessionAttributes.put(name, sessionAttr);
        }
        session = request.getSession(false);
    }

    public void insertAttributes(HttpServletRequest request) {
        requestAttributes.forEach((k, v) -> request.setAttribute(k, v));
        if (request.getSession(false) != null) {
            sessionAttributes.forEach((k, v) -> request.getSession().setAttribute(k, v));
        }
    }

    public void putRequestAttribute(String name, Object attr) {
        requestAttributes.put(name, attr);
    }

    public void putSessionAttribute(String name, Object attr) {
        sessionAttributes.put(name, attr);
    }

    public String getRequestParameters(String name, int index) {
        return requestParameters.get(name) == null ? null : requestParameters.get(name)[index];
    }

    public Object getSessionAttribute(String name) {
        return sessionAttributes.get(name);
    }

    public void invalidateSession() {
        if (session != null) {
            session.invalidate();
        }
    }

    public ServletContext getContext() {
        return session.getServletContext();
    }

    @Override
    public String toString() {
        return "RequestContent{" +
                ", requestAttributes=" + requestAttributes +
                ", requestParameters=" + requestParameters +
                ", sessionAttributes=" + sessionAttributes +
                '}';
    }
}
