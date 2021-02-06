package com.yuki.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/*
*
*  c-out - 显示html文本
*  <c:out value="" excapeXml="true"> - 显示html文本
*
*  c-import - 导入jsp页面，并且传入参数
*
*
* */
@WebServlet("/oth")
public class OtherServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String hobby = req.getParameter("hobby");
        System.out.println(name);
        System.out.println(hobby);
        // 2. doget
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置属性
        req.setAttribute("htmlStr","<h1>hello-world</h1>");
        // 1. 设置 c:url参数
        req.setAttribute("hobby", Arrays.asList("sing", "dance"));
        req.setAttribute("name","yuki");
        // 2. 请求重定向
        req.getRequestDispatcher("/WEB-INF/oth.jsp").forward(req,resp);
    }
}
