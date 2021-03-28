package com.yuki.aspect;

import com.yuki.aop.CatBeforeAdvice;
import com.yuki.aop.CatFace;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CatHandTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:aspect-hand.xml");
        // ProxyFactoryBean - 手动代理
        CatFace cat = context.getBean("cat", CatFace.class);
        cat.fish("knvie");


    }
}
