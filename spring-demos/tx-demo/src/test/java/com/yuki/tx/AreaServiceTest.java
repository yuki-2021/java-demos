package com.yuki.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AreaServiceTest {


    public static void main(String[] args) {
        // 1. 注册Context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-service.xml");
        // 2. 插入数据
        AreaService areaService = context.getBean(AreaService.class);
        areaService.insert();

    }
}
