package com.yuki.demo1;


import com.yuki.demo1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@RunWith(JUnit4.class)
public class SpringDemo1 {

    /*
     * 获取Bean组件
     * */
    @Test
    public void test0() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService5",UserService.class);
        userService.getUsers();
    }




    /*
    * 测试Id、name、class - 配置基础Bean
    * */
    @Test
    public void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceId", UserService.class);
        System.out.println("-----------");
       userService.getUsers();
        System.out.println("-----------");
    }


    /*
    * factoryMethod - 使用工厂方法创建Bean
    * */
    @Test
    public void testFactoryMethod() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceFactoryMethod", UserService.class);
        System.out.println("-----------");
        userService.getUsers();
        System.out.println("-----------");
    }

    /*
    *  factoryBean - 使用简单工厂创建Bean
    * */
    @Test
    public void testSimpleFac() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceSimpleFactory", UserService.class);
        System.out.println("-----------");
        userService.getUsers();
        System.out.println("-----------");
    }


    /*
     * abstract、parent  - 模板 和 实现
     * abstrct 的Bean不能 实例化
     * parent 用于复用模板
     * */
    @Test
    public void testAbstract() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceAbstract",UserService.class);
        System.out.println("-----------");
        userService.getUsers();
        System.out.println("-----------");
    }


    /*
    * dependsOn - Bean实例化的顺序
    * */
    @Test
    public void testDependsOn() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}



















