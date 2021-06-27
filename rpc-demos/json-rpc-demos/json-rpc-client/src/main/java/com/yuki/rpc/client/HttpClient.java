package com.yuki.rpc.client;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.yuki.rpc.api.DogService;
import com.yuki.rpc.entity.Dog;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

/*
* 调用Http+JsonRpcServer方式
* */
@Slf4j
public class HttpClient {

    public static void main(String[] args) throws MalformedURLException {
        // 1. 使用ProxyUtil创建proxy，proxy使用JsonRpcHttpClient来发送请求
        DogService dogServiceProxy = ProxyUtil.createClientProxy(
                HttpClient.class.getClassLoader(), //classLoader
                DogService.class, // proxyClazz
                new JsonRpcHttpClient(new URL("http://localhost:8080/dog"))); // JsonRpcClient

        // 2. 调用proxy
        Dog dog = dogServiceProxy.findDogById("ddd");
        log.info("掉用rpc,结果是: {}",dog);
    }
}
