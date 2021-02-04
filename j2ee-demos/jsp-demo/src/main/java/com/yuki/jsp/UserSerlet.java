package com.yuki.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
*  测试 <%@ page%> 的 isErrorPage 和 errorPage
*    - isErrorPage 用于指定错误页，来显示错误信息，页面中可以用`exception`对象
*    - errorPage  显示指定错误页。
*
*  错误页优先级
*     - 1. errorPage属性显示指定的
*     - 2. web.xml指定的errorpage
*     - 3. tomcat默认的
* */
public class UserSerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 2. 转到页面
        req.getRequestDispatcher("/WEB-INF/user/user.jsp").forward(req,resp);
    }
}
