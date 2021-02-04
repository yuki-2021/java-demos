package com.yuki.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
*  JSP四大语法
*
*  JSP四大语法
*   - 输出语法 <%= %>
*   - 定义语法 <%! %>
*       1. 定义方法、变量
*       2. 不能使用`jsp内置九大对象`
*   - java代码块 <% %>
*       1. 用来定义变量(局部变量)、写循环。
*   - JSP指令 <%@ %>
*       1. 指令用于设置页面(设置编码、引入Java类、设置错误页面)、引入Jsp、引入标签库
*       2. <%@ page %> language、contentType、pageEncoding、import、errorPage、isErrorPage
*       3. <%@ include file="xx" %>
*       4. <%@ taglib prefix="xx" uri="xx" %>
* */
public class SalaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 1. init data
        req.setAttribute("salList",initSalList());
        req.setAttribute("title","工资试算表");
        // 2. forward to servlet
        req.getRequestDispatcher("/WEB-INF/salary.jsp").forward(req,resp);
    }

    private List<Double> initSalList() {
        int baseSal = 1500;
        List<Double> salList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            salList.add(baseSal + baseSal * i * 0.1);
        }
        for (int i = 5; i <= 10; i++) {
            salList.add(baseSal + baseSal * i * 0.2);
        }
        for (int i = 11; i <= 15; i++) {
            salList.add(baseSal + baseSal * i * 0.25);
        }
        return salList;
    }
}
