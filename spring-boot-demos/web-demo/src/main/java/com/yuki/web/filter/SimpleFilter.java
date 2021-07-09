package com.yuki.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
* 方式1  - @Component注册Filter
* */
//@Component("simple")
@Slf4j
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 打印
        log.info("this is simple filter");
        // 2. 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
