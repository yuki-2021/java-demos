package com.yuki.rpc.stream;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.googlecode.jsonrpc4j.StreamServer;
import com.yuki.rpc.api.DogService;
import com.yuki.rpc.api.UserService;
import com.yuki.rpc.stream.service.DogServiceImpl;
import com.yuki.rpc.stream.service.UserServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;

public class ServiceServer {

    public static void main(String[] args) throws IOException {
        // 1. 创建proxy代理对象
        Object proxy = ProxyUtil.createCompositeServiceProxy(
                ServiceServer.class.getClassLoader(),
                new Object[]{new UserServiceImpl(), new DogServiceImpl()},
                new Class<?>[]{UserService.class, DogService.class},
                true);

        // 2. 创建JsonRpcServer - 负责解析JsonRpc报文，调用proxy,回写JsonRpc响应报文
        JsonRpcServer jsonRpcServer = new JsonRpcServer(proxy,DogService.class);

        // 3. 创建StreamServer - 负责监听端口
        int maxThreads = 50;
        int port = 1420;
        StreamServer server = new StreamServer(jsonRpcServer, maxThreads, new ServerSocket(port));

        // 4. 启动StreamServer
        server.start();
    }
}
