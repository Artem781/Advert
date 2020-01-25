package by.it.advertproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_LANG;
import static by.it.advertproject.command.impl.SetLanguageCommand.ENGLISH;

@WebFilter(filterName = "AdvertLocalizationFilter", urlPatterns = "/*")
public class LocalizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            HttpSession session = httpRequest.getSession();
            if (session.getAttribute(ATTR_NAME_LANG) == null) {
                session.setAttribute(ATTR_NAME_LANG, ENGLISH);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
