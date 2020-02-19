//package by.it.advertproject.filter;
//
//import by.it.advertproject.exception.ServletException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;
//
//@WebFilter(urlPatterns = {"/jsp/*"},
//initParams = {@WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})
//public class PageRedirectSecurityFilter implements Filter {
//    private String indexPath;
//    public void init(FilterConfig filterConfig) throws ServletException{
//        indexPath = filterConfig.getInitParameter("INDEX_PATH");
//    }
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
//            throws IOException, ServletException{
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public boolean isLoggable(LogRecord record) {
//        return false;
//    }
//}
