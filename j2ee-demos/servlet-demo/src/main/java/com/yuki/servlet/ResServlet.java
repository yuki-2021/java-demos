package com.yuki.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   @title HttpServletResponse 学习测试
*
 *   1. 设置headr和cookie - setHeader、addHeader、setCookie
*   2. 设置miniType和响应体 - setContentType(浏览器如何解析响应体)、getOutStream(写响应体)、flushBuffer(结束响应，后面代码不执行)
*   3. 错误和重定向 - sendError(code,msg)、sendRedirect(302)
*
* */
@WebServlet("/res")
public class ResServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. addHeader、setHeader、containsHeader、addCookie、
        resp.setHeader("aa","aaa");
        resp.addHeader("bb","bbb");
        resp.addCookie(new Cookie("userInfoSessionKey","user:1")); // 设置userInfo的sessionid
        // 2. setContentType(浏览器如何解析responsebody)、getOuputStream(写responseBody)、getBufferSize()、flushBuffer()
        resp.setContentType("text/xml;charset=utf-8");
        resp.getOutputStream().println("<h1>hello-world</h1>");
        resp.flushBuffer(); // 直接推送流到客户端，后面代码直接跳过
        // 3. 重定向和错误 -
        // 3. encoodeURL()、sendError()、sendRedirect
        // resp.sendError(500,"就是要出错");
    }
}
