package com.yuki.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

    public static void main(String[] args) {
        // 1. context上下文
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:aspect.xml");
        // 2. 注解
        Cat cat = context.getBean(Cat.class);
        cat.fish("knive");
    }
}
