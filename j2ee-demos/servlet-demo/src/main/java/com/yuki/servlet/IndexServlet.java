package com.yuki.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/*
* 主页
*
* */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 可以 获取到 session
        if(req.getSession(true).getAttribute("user") == null) { // not login
            resp.sendRedirect("/login");
        } else  { // has login
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
        }



    }
}
