package com.yuki.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CatTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:aop.xml");
        // ProxyFactoryBean - 手动代理
        CatFace cat = context.getBean("cat", CatFace.class);
        // cat.fish("knvie");

        // 编码创建 --------------------
        CatFace catTarget = context.getBean("catTarget", CatFace.class);
        ProxyFactory proxyFactory = new ProxyFactory(catTarget); // 目标类
        proxyFactory.addAdvice(new CatBeforeAdvice()); // 通知
        proxyFactory.addInterface(CatFace.class); // 实现的接口
        CatFace catProxy = (CatFace) proxyFactory.getProxy();
        catProxy.fish("knive");
    }
}
