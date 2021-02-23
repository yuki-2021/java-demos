package com.yuki.demo1.config;

import com.yuki.demo1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(JUnit4.class)
public class SimpleDemo2 {

    /*
     * 获取Bean组件
     * */
    @Test
    public void test1() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService1",UserService.class);
        userService.getUsers();
    }

    /*
     * 工厂方法 - 获取组件
     * */
    @Test
    public void testFactoryMethod() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService2", UserService.class);
        userService.getUsers();
    }

    /*
     * 简单工厂 - 获取组件
     * */
    @Test
    public void testSimpleFac() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService3", UserService.class);
        userService.getUsers();
    }

    /*
     * @dependsOn - 前后顺序
     * */
    @Test
    public void test() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

    }
}
