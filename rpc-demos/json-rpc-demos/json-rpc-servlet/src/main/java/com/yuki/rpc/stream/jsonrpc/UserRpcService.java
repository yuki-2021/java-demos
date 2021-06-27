package com.yuki.rpc.stream.jsonrpc;

import com.googlecode.jsonrpc4j.JsonRpcServer;

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
    private JsonRpcServer jsonRpcServer;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        jsonRpcServer.handle(req,resp);
    }
}
