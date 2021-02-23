package com.yuki.demo2.config;

import com.yuki.demo2.entity.Car;
import com.yuki.demo2.entity.Cat;
import com.yuki.demo2.entity.CollectBean;
import com.yuki.demo2.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class ConfigDemo2 {

    /*
    * 测试Proptory注入
    * */
    @Test
    public void testProp() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        Car car1 = context.getBean("car1", Car.class);
        Employee emp1 = context.getBean("emp1", Employee.class);
        System.out.println(emp1.getCar() == car1); // true
        System.out.println(emp1);
    }

    /*
    * 测试 -  构造注入
    * */
    @Test
    public void testConstruct() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        Cat cat1 = context.getBean("cat1", Cat.class);
        System.out.println(cat1);
    }

    /*
     * 测试 -  注入null
     * */
    @Test
    public void testNull() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        Cat cat2 = context.getBean("cat2", Cat.class);
        System.out.println(cat2);
    }


    /*
    * 测试 - 注入集合
    * */
    @Test
    public void testCollect() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        CollectBean collect = context.getBean("collect", CollectBean.class);
        System.out.println(collect);
    }

    /*
    * 测试scope
    * */
    @Test
    public void testScope() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        System.out.println("----------------");
        Cat cat1 = context.getBean("catPrototype", Cat.class);
        Cat cat2 = context.getBean("catPrototype", Cat.class);
        System.out.println(cat1 == cat2);
    }

    /*
    *
    * 在测试@Scoped,时候 同时 指定 aop代理 和 proxyMode 会发生什么？
    *   - 会先创建代理类, 作为target
    *   - 然后交给ProxyMode的代理管理·
    * */
    @Test
    public void testAop() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InjectConfig.class);
        System.out.println("----------------");
        Cat cat1 = context.getBean("catPrototype", Cat.class);
        cat1.eat();
    }
}
