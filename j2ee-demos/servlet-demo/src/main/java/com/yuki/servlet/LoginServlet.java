package com.yuki.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* Session 作用是为不同用户保存不同信息
*   可用用来事项 身份验证、权限控制、数据保存
*
* cookie 用来存放session的key
*
* Session
*
* Cookie
*  - 1. 获取cookie req.getCookies
*
* */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // login.jsp
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession(false));
        // 1. dispatcher
        req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req,resp);
    }

    // chekck login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. getParamter
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2. check User
        User user = new User(username, password);
        if(authUser(user)) { // success
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            resp.sendRedirect("/index");
        } else { // fail
            req.setAttribute("errMsg","就是不让登陆 \uD83D\uDE24");
            doGet(req,resp);
        }
    }

    private boolean authUser(User user) {
        boolean res = false;
        if(user.getUsername().equals("admin") && user.getPassword().equals("123456")) {
            res = true;
        }
        return res;
    }

}
