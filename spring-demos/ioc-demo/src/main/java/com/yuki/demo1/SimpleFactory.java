package com.yuki.demo1;

import com.yuki.demo1.service.UserService;
import com.yuki.demo1.service.UserServiceImpl;

public class SimpleFactory {

    public UserService fac() {
        System.out.println("实例工厂初始化");
        return new UserServiceImpl();
    }
}
