package com.yuki.configure;

import com.yuki.configure.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties(value = User.class)
@SpringBootApplication
public class ConfigureApplication {

    public static void main(String[] args) {

       SpringApplication.run(ConfigureApplication.class);
    }

}
