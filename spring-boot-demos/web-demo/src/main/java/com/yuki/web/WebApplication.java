package com.yuki.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;
import java.util.Map;
import java.util.Set;



@SpringBootApplication
public class WebApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(WebApplication.class, args);

        // 输出所有的HttpMessageConverter
        HttpMessageConverters converters = context.getBean(HttpMessageConverters.class);
        List<HttpMessageConverter<?>> converterList = converters.getConverters();
        System.out.println(converterList);
    }

}
