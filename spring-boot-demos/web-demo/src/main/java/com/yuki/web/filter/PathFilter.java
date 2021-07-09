package com.yuki.web.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "logFilter",urlPatterns = "/*")
//@Component
public class PathFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("==============request url ==============");
        System.out.println("scheme = " + request.getScheme()); // http
        System.out.println("method = " + request.getMethod()); // get
        System.out.println("serverName = " + request.getServerName()); // servername = localhost
        System.out.println("serverPort = " + request.getServerPort()); // serverPort = 8080
        System.out.println(request.getServletPath());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println("==============  END    ==================");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
