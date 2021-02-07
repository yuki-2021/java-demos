package com.yuki.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;


/*
*  @title HttpServletRequest学习测试
*
*  1. 请求参数相关 - getParameterNames、getParameter(单选框、输入框)tParameterValues(获取多选框)、getHeader()
*  2. 客户端相关 - method(请求方式)、protocol(协议)、add(ip地址)、host(域名)、port(端口)、uri、queryStr
*  3. 服务端相关 - serverAddr(服务器ip)、serverPort(服务器端口)、serverPath(servlet路径)
*  4. 转发相关 - setAttribute、getRequestDispatcher、forward()
*  5. 获取其他对象 - getServletConfig(initParam)、getServletContext(app对象)、getSession、getCookies()
* */
@WebServlet(urlPatterns = "/simple",initParams = {
        @WebInitParam(name = "servletConfig",value = "this is servlet init params")
})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletConfig 测试initParams
        System.out.println(this.getServletConfig().getInitParameter("servletConfig"));

        // 1. getParamter()/getParamterNames()/getParamterValues()
        System.out.println("--------------getParam()、getParams()、getParamVals()---------------------");
        Enumeration<String> iterator = req.getParameterNames();
        while (iterator.hasMoreElements()) {
            System.out.println(iterator.nextElement());
        }
        System.out.println(req.getParameter("name"));
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(hobbies);
        // 2. uri相关 -
        System.out.println("--------------method、protocol、addr、host、port、uri、queryStr---------------------");
        System.out.println(req.getMethod());    // 请求方式GEt-POST
        System.out.println(req.getProtocol()); // 协议
        System.out.println(req.getRemoteAddr()); // ip
        System.out.println(req.getRemoteHost()); // ip域名
        System.out.println(req.getRemotePort()); // port
        System.out.println(req.getRequestURI()); // uri
        System.out.println(req.getQueryString()); // queryString
        // 3. 服务器相关信息-- sserverName、serverPort、servletPath
        System.out.println(req.getServerName()); // localhost
        System.out.println(req.getServletPath()); // simple
        System.out.println(req.getServerPort()); // 8080
        // 4. 设置属性 setAttribute和 getRequestDispatcher和forward - 重定向
        // 5 获取其他对象 - initParams、session、cookies、applicationContext
        String cp = getServletConfig().getInitParameter("servletConfig");
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getValue());
        }
        HttpSession session = req.getSession(true);
        ServletContext servletContext = req.getServletContext();
    }
}
