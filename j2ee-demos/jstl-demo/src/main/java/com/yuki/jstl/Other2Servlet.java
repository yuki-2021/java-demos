package com.yuki.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/*
* 测试c:uri
*   - 传递的参数
*
* */
@WebServlet("/oth2")
public class Other2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String hobby = req.getParameter("hobby");
        System.out.println(name);
        System.out.println(hobby);

    }
}
