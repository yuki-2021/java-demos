package com.yuki.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 静态资源
*
* 默认路径
*   classpath:/META-INF/resources/**
*   classpath:/resources/**
*   classpath:/static/**
*   classpath:/public/**
*
* 配置 静态资源url 和 静态资源位置
*   1. spring.resources.static-locations 和 spring.mvc.static-path-pattern
*   2. 配置一个 WebMvcConfigurer
*/
public class StaticConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/t/**")
                .addResourceLocations("classpath:/static1/");
    }
}
