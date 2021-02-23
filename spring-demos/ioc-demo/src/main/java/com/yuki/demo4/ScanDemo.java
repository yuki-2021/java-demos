package com.yuki.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class ScanDemo {

    /*
    * @ComponentScan - 测试组件扫描
    * @AutoWrited/@Value - 自动注入
    * */
    @Test
    public void testAnnoAuto() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        ProductService service = context.getBean(ProductService.class);
        service.getProducts();
    }

    /*
    * <Context-componentscan> - 组件扫描 + 自动注入
    *
    * */
    @Test
    public void testXMLAuto() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("auto.xml");
        ProductService service = context.getBean(ProductService.class);
        service.getProducts();
    }


    /*
    *
    * 测试 autowried属性
    *   - no/default 表示不装配
    *   -  byName 根据`属性name`寻找，找不到就是null。
    *   -  byType 根据`type`注入，找不到就是`null`,有多个`bean`，会报错。
    * */
    @Test
    public void testXMLAuto1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("auto2.xml");
        ProductService service = context.getBean(ProductService.class);
        service.getProducts();
    }


    /*
     *
     * 测试 @autowried属性
     *   - 默认是按照`类型装配`，扫描到多个直接报错。扫描不到直接报错。
     *   -  required属性false, - 扫描到0个，不报错
     *   -  @RQualified 配合 @Component("name") - 按照名称装配
     * */
    @Test
    public void textAutoWrite() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("auto.xml");
        ProductService service = context.getBean(ProductService.class);
        service.getProducts();
    }
}
