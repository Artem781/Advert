package by.it.advertproject.filter;

import by.it.advertproject.bean.Role;
import by.it.advertproject.exception.AdvertException;
import by.it.advertproject.util.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCESS_LEVEL;
import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCOUNT_ID;
import static by.it.advertproject.command.CommandFactory.PARAM_NAME_COMMAND;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(AuthFilter.class);

    private static final String PUBLIC_ACTION_PROPERTY_KEY = "action.public";
    private static final String ADMIN_ACTION_PROPERTY_KEY = "action.admin";
    private static final String COMMA = ",";
    private static final String SEPARATOR = "/";
    private static final String NOT_AUTH_MESSAGE = "not authorization accesses";
    private static final String BAD_ACCESS_LEVEL = "user attempt use admin action";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.log(Level.INFO, "from AuthFilter. doFilter method.");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String parameterCommand = httpRequest.getParameter(PARAM_NAME_COMMAND);
        logger.log(Level.INFO, "from AuthFilter. doFilter method. parameterCommand: " + parameterCommand);

        try {
            logger.log(Level.INFO, "from AuthFilter. doFilter method. if (httpRequest.getParameter(PARAM_NAME_COMMAND) != null) { ");
            if (httpRequest.getParameter(PARAM_NAME_COMMAND) != null) {
                logger.log(Level.INFO, "from AuthFilter. doFilter method.if (!isPublicAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND))): " + (!isPublicAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND))));
                if (!isPublicAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND))) {
                    logger.log(Level.INFO, "from AuthFilter. doFilter method. if (httpRequest.getSession(false) == null): " + (httpRequest.getSession(false) == null));

                    if (httpRequest.getSession(false) == null) {
                        logger.log(Level.INFO, "from AuthFilter. throw new AdvertException(NOT_AUTH_MESSAGE);");
                        throw new AdvertException(NOT_AUTH_MESSAGE);
                    } else {

                        logger.log(Level.INFO, "from AuthFilter. if (httpRequest.getSession(false).getAttribute(ATTR_NAME_ACCOUNT_ID) == null) {");
                        if (httpRequest.getSession(false).getAttribute(ATTR_NAME_ACCOUNT_ID) == null) {
                            logger.log(Level.INFO, "from AuthFilter. throw new AdvertException(NOT_AUTH_MESSAGE);");

                            throw new AdvertException(NOT_AUTH_MESSAGE);
                        }
                    }
                }
                if (isAdminAccessAction(httpRequest.getParameter(PARAM_NAME_COMMAND)) &&
                        httpRequest.getSession(false).getAttribute(ATTR_NAME_ACCESS_LEVEL)
                                .equals(Role.USER)) {
                    throw new AdvertException(BAD_ACCESS_LEVEL);
                }
            }
            filterChain.doFilter(httpRequest, httpResponse);
        } catch (AdvertException e) {
            logger.log(Level.WARN, e.getMessage());
            httpResponse.sendRedirect(httpRequest.getContextPath() + SEPARATOR);
        }
    }

    private boolean isPublicAccessAction(String action) {
        logger.log(Level.INFO, "from AuthFilter. isPublicAccessAction method.");
        String publicActionProperty = ConfigurationManager.getProperty(PUBLIC_ACTION_PROPERTY_KEY);
        List<String> publicActions = Arrays.asList(publicActionProperty.split(COMMA));
        publicActions.forEach(a -> a = a.trim());
        logger.log(Level.INFO, "from AuthFilter. isPublicAccessAction method. publicActions.forEach(a -> a = a.trim());");
        logger.log(Level.INFO, "from AuthFilter. publicActions.contains(action): " + publicActions.contains(action));
        return publicActions.contains(action);
    }

    private boolean isAdminAccessAction(String action) {
        String adminActionProperty = ConfigurationManager.getProperty(ADMIN_ACTION_PROPERTY_KEY);
        List<String> adminActions = Arrays.asList(adminActionProperty.split(COMMA));
        adminActions.forEach(a -> a = a.trim());
        return adminActions.contains(action);
    }
}
