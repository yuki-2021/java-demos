package com.yuki.redis.config;

import com.yuki.redis.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = {UserService.class})
@Import(RedisConfig.class)
public class RootConfig {

}
