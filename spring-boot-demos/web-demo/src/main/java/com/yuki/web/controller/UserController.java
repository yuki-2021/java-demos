package com.yuki.web.controller;

import com.yuki.web.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/hello")
    public String hello() {
        return "hello-world";
    }

    @GetMapping
    public User user() {
        return new User("admin","123456");
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

}
