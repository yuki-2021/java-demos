package com.yuki.international;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
@Slf4j
public class InternationalDemoApplication {

    public static void main(String[] args) {
        // 1. 创建Context
        ConfigurableApplicationContext context = SpringApplication.run(InternationalDemoApplication.class, args);

        // 2. 获取Message
        String msg = context.getMessage("dog.name", null, Locale.US);
        log.info("已经取出user.name,值是：{}",msg);
    }

}
