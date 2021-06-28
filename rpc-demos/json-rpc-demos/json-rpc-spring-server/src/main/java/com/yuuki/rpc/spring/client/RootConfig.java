package com.yuuki.rpc.spring.client;

import com.yuuki.rpc.spring.client.service.DogServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* RootApplication的配置文件
* */
@Configuration
@ComponentScan(basePackageClasses = {DogServiceImpl.class})
public class RootConfig {
}
