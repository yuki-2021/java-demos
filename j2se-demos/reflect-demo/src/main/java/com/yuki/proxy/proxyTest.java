package com.yuki.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/*
*  测试 动态代理
*
* */
public class proxyTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UserService userService = AuthProxyFactory.getProxySimple(new UserServiceImpl());
        userService.deal();
    }

    private static void proxyNormal() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 目标对象和横切逻辑
        InvocationHandler invocationHandler = new AuthInvocationHandler(new UserServiceImpl());
        // 生成代理类
        Class<UserService> userServiceProxy = (Class<UserService>) Proxy.getProxyClass(UserService.class.getClassLoader(), new Class[]{UserService.class});
        // 生成代理对象
        Constructor<UserService> constructor = userServiceProxy.getConstructor(new Class[]{InvocationHandler.class});
        UserService userService = constructor.newInstance(invocationHandler);
        userService.deal();
    }

    /*
    * 简单方式生成 代理类 和 代理对象
    *
    * */
    private static void proxySimple() {
        // 横切逻辑 和 目标对象target
        InvocationHandler handler = new AuthInvocationHandler(new UserServiceImpl());
        // 生成代理类，创建代理对象
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                new Class[]{UserService.class},handler);
        userServiceProxy.deal();
    }

}
