package com.yuki.configure.web;

import com.yuki.configure.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
     * Random - 访问随机数
     * */
    @Value("${rand.value}")
    private int age;

    @GetMapping("/random")
    public Integer getRandom() {
        return age;
    }



    /**
     * User - 测试@PropertyConfiguration
     * */
    @Autowired
    private User user;

    @GetMapping("/user")
    public User user() {
        return user;
    }
}
