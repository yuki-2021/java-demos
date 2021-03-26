package com.yuki.tx;


import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 测试 - xml - 声明式事务
* */
public class CodeServiceTest {


    public static void main(String[] args) {
        // 1. 注册Context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-xml-service.xml");
        // 2. 插入数据
        CodeService xmlService = context.getBean(CodeService.class);
        xmlService.useTxManager();

    }
}
