package com.yuki.rpc.spring.client.config;

import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;
import com.yuki.rpc.api.DogService;
import com.yuki.rpc.spring.client.web.DogController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = DogController.class)
public class WebConfig {

    /**
    * JsonProxyFactory会创建Proxy
    *
    * Proxy构建报文，并发送请求
    * */
    @Bean
    public JsonProxyFactoryBean dogService() {
        // 1. 使用JsonProxyFactoryBean创建代理
        JsonProxyFactoryBean jsonProxyFactoryBean = new JsonProxyFactoryBean();
        jsonProxyFactoryBean.setServiceUrl("http://localhost:8081/dog");
        jsonProxyFactoryBean.setServiceInterface(DogService.class);

        // 2.
        return jsonProxyFactoryBean;

    }
}
