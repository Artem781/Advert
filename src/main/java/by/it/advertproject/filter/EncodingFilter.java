package by.it.advertproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdvertEncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private static final String CHARTER_ENCODING = "utf-8";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpRequest.setCharacterEncoding(CHARTER_ENCODING);
        httpResponse.setCharacterEncoding(CHARTER_ENCODING);
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
