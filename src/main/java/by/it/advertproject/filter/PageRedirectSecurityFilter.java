package by.it.advertproject.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_ACCESS_LEVEL;
import static by.it.advertproject.command.CommandType.*;

@WebFilter(urlPatterns = {"/jsp/*"},
initParams = {@WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})
//public class SecurityFilter extends GenericFilter {
public class PageRedirectSecurityFilter implements Filter {
    private String indexPath;

    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // переход на заданную страницу
        httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }


//    private static final Logger LOGGER = LogManager.getLogger(SecurityFilter.class);
//    public static final String PARAM_NAME_COMMAND = "command";
//    public static final String UNKNOWN_PARAM = "unknown";
//    public static final String ADMIN = "administrator";
//    public static final String USER = "user";
//
//
//    private static final Set<String> ALLOWED_USER_PATHS =
//            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
//                    TO_ADMIN_PROFILE.name(), TO_SIGN_UP.name(),
//                    TO_SIGN_IN.name(), TO_MAIN.name(), TO_EDIT_PROFILE.name(),
//                    TO_USER_PROFILE.name(), TO_ADMIN_PROFILE.name(), TO_CREATE_ADVERT.name(),
//                    TO_ERROR.name(), UPDATE_PHOTO.name(), UPDATE_PROFILE_DATA.name(),
//                    DELETE_USER.name(), SIGN_IN.name(), LOGOUT.name(), SIGN_UP.name(),
//                    SET_LANG.name(), CREATE_ADVERT.name())));
//
//    private static final Set<String> ALLOWED_ADMIN_PATHS = new HashSet<>(
//            Arrays.asList(TO_ADMIN_PROFILE.name(), TO_SIGN_UP.name(),
//                    TO_SIGN_IN.name(), TO_MAIN.name(), TO_EDIT_PROFILE.name(),
//                    TO_USER_PROFILE.name(), TO_ADMIN_PROFILE.name(), TO_CREATE_ADVERT.name(),
//                    TO_ERROR.name(), UPDATE_PHOTO.name(), UPDATE_PROFILE_DATA.name(),
//                    DELETE_USER.name(), SIGN_IN.name(), LOGOUT.name(), SIGN_UP.name(),
//                    SET_LANG.name(), CREATE_ADVERT.name()));
//
//
//    private static final Set<String> ALLOWED_UNKNOWN_PATHS = new HashSet<>(
//            Arrays.asList(TO_MAIN.name(), SET_LANG.name(), TO_ERROR.name(),
//                    TO_SIGN_IN.name(), TO_SIGN_UP.name(), SIGN_IN.name(), SIGN_UP.name()));
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession session = httpServletRequest.getSession();
//        String type = (String) session.getAttribute(ATTR_NAME_ACCESS_LEVEL);
//        String command = httpServletRequest.getParameter(PARAM_NAME_COMMAND);
//        String userRole = (type == null ? UNKNOWN_PARAM : type);
//        try {
//            if (command != null) {
//                switch (userRole) {
//                    case ADMIN:
//                        if (!ALLOWED_ADMIN_PATHS.contains(command.toUpperCase())) {
//                            ((HttpServletResponse) servletResponse)
//                                    .sendRedirect(httpServletRequest
//                                            .getServerName() + ":" + httpServletRequest
//                                            .getServerPort() + httpServletRequest
//                                            .getContextPath() + httpServletRequest
//                                            .getServletPath());
//                            return;
//                        }
//                        break;
//                    case USER:
//                        if (!ALLOWED_USER_PATHS.contains(command.toUpperCase())) {
//                            ((HttpServletResponse) servletResponse)
//                                    .sendRedirect(httpServletRequest
//                                            .getServerName() + ":" + httpServletRequest
//                                            .getServerPort() + httpServletRequest
//                                            .getContextPath() + httpServletRequest
//                                            .getServletPath());
//                            return;
//                        }
//                        break;
//                    default:
//                        if (!ALLOWED_UNKNOWN_PATHS.contains(command.toUpperCase())) {
//                            ((HttpServletResponse) servletResponse)
//                                    .sendRedirect(httpServletRequest
//                                            .getServerName() + ":" + httpServletRequest
//                                            .getServerPort() + httpServletRequest
//                                            .getContextPath() + httpServletRequest
//                                            .getServletPath());
//                            return;
//                        }
//                        break;
//                }
//            }
//            filterChain.doFilter(servletRequest, servletResponse);
//        } catch (Exception e) {
//            LOGGER.warn(" Exception in SecurityFilter ", e);
//            ((HttpServletResponse) servletResponse).sendRedirect(httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath() + httpServletRequest.getServletPath());
//        }
//    }
}





//    private String indexPath;
//    public void init(FilterConfig fConfig) throws ServletException {
//        indexPath = fConfig.getInitParameter("INDEX_PATH");
//    }
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        // переход на заданную страницу
//        httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
//        chain.doFilter(request, response);
//    }
//    public void destroy() {
//    }