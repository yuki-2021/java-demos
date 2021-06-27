package com.yuki.rpc.client;

import com.googlecode.jsonrpc4j.JsonRpcClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.yuki.rpc.api.DogService;
import com.yuki.rpc.entity.Dog;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/*
* 调用Http+JsonRpcServer方式
* */
@Slf4j
public class StreamClient {

    public static void main(String[] args) throws IOException {
        // 1. ProxyUtil创建proxy，创建报文，使用JsonRpcClient发送
        InetAddress bindAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(bindAddress, 1420);
        DogService dogServiceProxy = ProxyUtil.createClientProxy(
                StreamClient.class.getClassLoader(), //classLoader
                DogService.class, // proxyClazz
                new JsonRpcClient(),socket); // JsonRpcClient

        // 2. 调用proxy
        Dog dog = dogServiceProxy.findDogById("ddd");
        log.info("掉用rpc,结果是: {}",dog);
    }
}
