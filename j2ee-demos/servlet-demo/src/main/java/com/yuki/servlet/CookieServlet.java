package com.yuki.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  @title Cookie学习和测试
*
*  1. 设置和获取Cookie
*       req.getCookies()
*       resp.addCookie()
*
*  2. Cookie对象的方法
*       getName
*
*
*
* */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    // 测试Cookie - 先访问个JSP - 会自动创建Session - 就会有cookie保证JSESSIONID
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Cookie - getCookies
        System.out.println("-----------COOKIE LIST-----------");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        // 设置Cookie - setCookie - 设置个www.baidu.com 下次不会传递过来
        Cookie cookie1 = new Cookie("set1", "set1");
        cookie1.setDomain("www.baidu.com");
        resp.addCookie(cookie1);
        // 遍历Cookie
        System.out.println("-----------COOKIE LIST-----------");
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getSecure());
            System.out.println(cookie.getComment());
            System.out.println(cookie.getVersion());
        }
        // 转发到JSP显示
        req.getRequestDispatcher("/WEB-INF/cookie.jsp").forward(req,resp);

    }
}
