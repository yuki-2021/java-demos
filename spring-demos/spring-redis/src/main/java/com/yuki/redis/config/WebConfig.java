package com.yuki.redis.config;

import com.yuki.redis.web.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackageClasses = UserController.class)
public class WebConfig {
}
