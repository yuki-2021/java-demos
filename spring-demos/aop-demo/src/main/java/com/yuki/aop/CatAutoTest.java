package com.yuki.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CatAutoTest {

    public static void main(String[] args) {
        // 1. 创建context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:aop-auto.xml");

        // 2. 切入
        CatFace catTarget = context.getBean(CatFace.class);
        catTarget.eat();
//        catTarget.fish("knive");
    }
}
