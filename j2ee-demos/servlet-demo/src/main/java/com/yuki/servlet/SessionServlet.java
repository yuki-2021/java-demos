package com.yuki.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* @title  HttpSession 学习和测试
*
*  1.  获取Session
*       getSession(false/true)
*
*  2. Session的属性 - id、ctime、atime、max-age
*      getId() - JSESSIONID
*      getCreateTime() - ctime创建时间
*      getLastAccessTime() - 最后访问时间
*      getMaxInterval()   - Session的生命周期★
*
* 3. Session的属性和生命
*      setInterval() - 过期时间
*      invalidate() - 立即过期
*      setAttr/getAttr() -设置和防止属性
*
* */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    // 先登录 - session中有值
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取session - getSession(true/false)
        HttpSession session = req.getSession(true);
        // 2. Session - 获取属性 getId、getCreationTime、getLastAccessedTime
        System.out.println("------- GET SESSION INFO--------");
        System.out.println(session.getId());
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());
        // 3. 操作Session过期 和 属性
        session.setMaxInactiveInterval(60); // 1分钟过期
        session.invalidate(); // 立即过期
        System.out.println("------- SESSION 已经过期 ------");
    }
}












