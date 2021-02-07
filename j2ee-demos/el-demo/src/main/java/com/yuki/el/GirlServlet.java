package com.yuki.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
*   EL语法
*       -  [内置对象].基本参数
*       -  [内置对象].pojo.字段名称
*
*   EL内置对象
*       - pageScope、requestScope、SessionScope、applicationScope - 访问setattribute()设置的内容
*       - param、paramValues、header、cookie、initParam
*
*   EL对象应用规则
*       - 1. 没有指定scope,会寻找 page-> request -> session -> application -> null
*       - 2. 对于访问param、header、cookie、initParam 需要显示指定
*       - 3. el无法访问 <%%> 定义的变量(局部变量)
*
* */
@WebServlet(name = "girlServlet",urlPatterns = "/girl")
public class GirlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 准备数据
        req.setAttribute("girlList",getGirlList());
        req.setAttribute("title","超女信息表");
        // 2. 请求转发
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getValue());
        }
        req.getRequestDispatcher("/WEB-INF/girl.jsp").forward(req,resp);
    }

    private List<Girl> getGirlList() {
        List<Girl> list = new ArrayList<>();
        list.add(new Girl("girl1",18,"city1", Arrays.asList("smoke","drink","eat")));
        list.add(new Girl("girl2", 19, "city2", Arrays.asList("sing", "paint", "study", "code")));
        return list;
    }
}
