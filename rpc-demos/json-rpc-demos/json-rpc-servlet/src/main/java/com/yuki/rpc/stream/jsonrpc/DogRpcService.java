package com.yuki.rpc.stream.jsonrpc;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.yuki.rpc.api.DogService;
import com.yuki.rpc.stream.service.DogServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* JsonRpcServer + HttpServlet
* JsonRpcServer - 负责解析参数、调用方法
* HttpServlet - 负责传输
* */
@WebServlet(urlPatterns = "/dog")
public class DogRpcService extends HttpServlet {

    /*
    * JsonRpcServer
    * */
    private JsonRpcServer jsonRpcServer = new JsonRpcServer(new DogServiceImpl(), DogService.class);


    public void init(ServletConfig config) {
        // 1. 创建Proxy
        Object proxy = ProxyUtil.createCompositeServiceProxy(
                DogRpcService.class.getClassLoader(),
                new Object[]{new DogServiceImpl()},
                new Class<?>[]{DogService.class},
                true
        );
        // 2. 创建JsonRpcServer
        this.jsonRpcServer = new JsonRpcServer(proxy, DogService.class);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3. 交给jsonRpcServer来解析JsonRpc报文，然后调用prxy处理，最后回写JsonRpc报文
        jsonRpcServer.handle(req,resp);
    }
}
