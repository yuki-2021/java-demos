package com.yuki.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class SimpleDemo3 {


    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("app3.xml");
        LifeBean lifeBean = context.getBean(LifeBean.class);
        lifeBean.life();
        context.close();
    }
}
