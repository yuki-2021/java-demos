package com.yuki.rpc.stream.jsonrpc;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.yuki.rpc.api.UserService;
import com.yuki.rpc.stream.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* JsonRpcServer + HttpServlet
* */
@WebServlet(urlPatterns = "/user")
public class UserRpcService extends HttpServlet {

    /*
    * JsonRpcServer
    * */
    private JsonRpcServer jsonRpcServer = new JsonRpcServer(new UserServiceImpl(), UserService.class);;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jsonRpcServer.handle(req,resp);
    }
}
