package com.yuki.demo2;

import com.yuki.demo2.entity.Cat;
import com.yuki.demo2.entity.CollectBean;
import com.yuki.demo2.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class SimpleDemo2 {

    /*
    * 属性注入 - ref、value
    * */
    @Test
    public void testProp() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app2.xml");
        Employee emp1 = context.getBean("emp1", Employee.class);
        System.out.println(emp1);
    }

    /*
    *  测试 Constructor-arg注入
    *   type - 构造参数类型不一样，可以使用type
    *   name - 解决 方法重载 或 参数类型重复 的问题
    * */
    @Test
    public void testConstruct() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app2.xml");
        Cat cat1 = context.getBean("cat1", Cat.class);
        Cat cat2 = context.getBean("cat2", Cat.class);
        Cat cat3 = context.getBean("cat3", Cat.class);
        System.out.println("----- cat1-----");
        System.out.println(cat1);
        System.out.println("----- cat2-----");
        System.out.println(cat2);
        System.out.println("----- cat3-----");
        System.out.println(cat3);
    }


    /*
    * 注入null
    * */
    @Test
    public void testNull() {
        ApplicationContext context = new ClassPathXmlApplicationContext("app2.xml");
        Cat cat4 = context.getBean("cat4", Cat.class);
        System.out.println(cat4);
    }

    /*
    * 注入 set/list/array/map/props
    * */
    @Test
    public void testCollect() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app2.xml");
        CollectBean collectBean = context.getBean("collectBean", CollectBean.class);
        System.out.println(collectBean.toString());
    }
}








