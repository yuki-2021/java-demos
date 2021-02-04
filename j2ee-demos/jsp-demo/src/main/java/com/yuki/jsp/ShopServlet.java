package com.yuki.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  测试 <%! %> 定义的方法和变量 `是不是成员变量`
*
*   - 使用<%!%> 定义的是`成员变量`,是`page作用域的变量`
*   - 使用时候，不需要`page.xxx`,直接使用`xxx`
*
* */
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码
        req.setCharacterEncoding("utf8");
        // 2. dispatcher
        req.getRequestDispatcher("/WEB-INF/shop.jsp").forward(req,resp);
    }
}
