package com.yuki.demo2a;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class ImportDemo {

    /*
    * 测试 @Import 引入 @Configuration
    * */
    @Test
    public void testImport() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigOutter.class);
        Dog dog1 = context.getBean("dog1", Dog.class);
        System.out.println(dog1);
    }

    /*
     * 测试 @ImportSource 引入 @Configuration
     * */
    @Test
    public void testImportSource() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigOutter.class);
        Dog dog2 = context.getBean("dog2", Dog.class);
        System.out.println(dog2);
    }


    @Test
    public void testXmlImport() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("outter.xml");
        Dog dog1 = context.getBean("dog1", Dog.class);
        Dog dog2 = context.getBean("dog2", Dog.class);
        System.out.println(dog1);
        System.out.println(dog2);


    }
}
