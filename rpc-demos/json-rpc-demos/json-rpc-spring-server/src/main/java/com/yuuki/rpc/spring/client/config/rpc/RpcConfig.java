package com.yuuki.rpc.spring.client.config.rpc;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import com.yuki.rpc.api.DogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

/**
 * json-rpc相关配置
 * */
@Configuration
public class RpcConfig {

    /**
     * BeanNameUrlHandlerMapping - 把Handler的id映射到url
     * */
    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(JsonServiceExporter dog) {
        return new BeanNameUrlHandlerMapping();
    }


    /**
     * JsonExporter会根据service和serviceInterface，自动创建proxy，然后创建JsonRpcService
     * 同时，实现了Servlet，会映射到url
     *
     * 请求到来时候，JsonServiceExporter调用JsonRpcServer处理
     * */
    @Bean(value = "/dog")
    public JsonServiceExporter dog(DogService dogService) {
        // 1. 创建JsonServiceExporter
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setServiceInterface(DogService.class);
        jsonServiceExporter.setService(dogService);

        // 2. 返回内容
        return jsonServiceExporter;
    }

}
