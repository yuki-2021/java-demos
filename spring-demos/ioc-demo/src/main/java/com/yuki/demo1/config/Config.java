package com.yuki.demo1.config;

import com.yuki.demo1.FactoryMethod;
import com.yuki.demo1.SimpleFactory;
import com.yuki.demo1.service.UserService;
import com.yuki.demo1.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Config {

    @Bean
    public UserService userService1() {
        return new UserServiceImpl();
    }

    @Bean
    @DependsOn("userService1")
    public UserService userService2() {
        return FactoryMethod.fac();
    }

    @Bean
    @DependsOn("userService2")
    public UserService userService3() {
        return new SimpleFactory().fac();
    }


}
