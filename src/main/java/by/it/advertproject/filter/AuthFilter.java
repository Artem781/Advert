//package by.it.advertproject.filter;
//
//import by.it.advertproject.bean.Role;
//import by.it.advertproject.exception.AdvertException;
//import by.it.advertproject.util.ConfigurationManager;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCESS_LEVEL;
//import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCOUNT_ID;
//import static by.it.advertproject.command.CommandProvider.PARAM_NAME_COMMAND;
//
//@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
//public class AuthFilter implements Filter {
//    private static Logger logger = LogManager.getLogger(AuthFilter.class);
//    private static final String PUBLIC_ACTION_PROPERTY_KEY = "action.public";
//    private static final String ADMIN_ACTION_PROPERTY_KEY = "action.admin";
//    private static final String COMMA = ",";
//    private static final String SEPARATOR = "/";
//    private static final String NOT_AUTH_MESSAGE = "not authorization accesses";
//    private static final String BAD_ACCESS_LEVEL = "user attempt use admin action";
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        try {
//            //есть команда
//            if (httpRequest.getParameter(PARAM_NAME_COMMAND) != null) {
//                //не в списке команд паблик
//                if (!isPublicAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND))) {
//                    if (httpRequest.getSession(false) == null) {
//                        throw new AdvertException(NOT_AUTH_MESSAGE);
//                    } else {
//                        if (httpRequest.getSession(false).getAttribute(ATTR_NAME_ACCOUNT_ID) == null) {
//                            throw new AdvertException(NOT_AUTH_MESSAGE);
//                        }
//                    }
//                }
//                // в списке паблик команд
//                // в списке админ команд и
//                if (isAdminAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND)) &&
//                        httpRequest.getSession(false).getAttribute(ATTR_NAME_ACCESS_LEVEL)
//                                .equals(Role.USER)) {
//                    throw new AdvertException(BAD_ACCESS_LEVEL);
//                }
//            }
//            filterChain.doFilter(httpRequest, httpResponse);
//        } catch (AdvertException e) {
//            logger.log(Level.WARN, e.getMessage());
//            httpResponse.sendRedirect(httpRequest.getContextPath() + SEPARATOR);
//        }
//    }
//
//    private boolean isPublicAccessAction(String action) {
//        String publicActionProperty = ConfigurationManager.getProperty(PUBLIC_ACTION_PROPERTY_KEY);
//        List<String> publicActions = Arrays.asList(publicActionProperty.split(COMMA));
//        return publicActions.contains(action);
//    }
//
//    private boolean isAdminAccessAction(String action) {
//        String adminActionProperty = ConfigurationManager.getProperty(ADMIN_ACTION_PROPERTY_KEY);
//        List<String> adminActions = Arrays.asList(adminActionProperty.split(COMMA));
//        adminActions.forEach(a -> a = a.trim());
//        return adminActions.contains(action);
//    }
//}
