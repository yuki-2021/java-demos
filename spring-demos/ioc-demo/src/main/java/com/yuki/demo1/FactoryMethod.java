package com.yuki.demo1;

import com.yuki.demo1.service.UserService;
import com.yuki.demo1.service.UserServiceImpl;

/*
*  工厂方法模式
*
* */
public class FactoryMethod {
    /*
    * 工厂方法
    * */
    public static UserService fac() {
        System.out.println("工厂方法实例化对象.....");
        return new UserServiceImpl();
    }
}
