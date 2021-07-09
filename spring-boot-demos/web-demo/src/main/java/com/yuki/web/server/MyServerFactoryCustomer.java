package com.yuki.web.server;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/*
* 设置嵌入式Server
*
* 优先级别
*         1. WebServerFactoryCustomer
*         2. application.properties
*         3. ConfigurableServletWebServerFactory
* */
@Component
public class MyServerFactoryCustomer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8082);
    }
}
