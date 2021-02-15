package com.yuki.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class AuthProxyFactory {


    public static <T> T getProxySimple(T target){
        // 1. 创建IncocationHandler - 横切逻辑 和 目标类
        InvocationHandler handler = new AuthInvocationHandler(target);
        // 2. 生成代理类，创建代理对象
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),handler);
    }

    public static <T> T getProxynormal(Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 创建IncocationHandler - 横切逻辑 和 目标类
        InvocationHandler handler = new AuthInvocationHandler(target);
        // 2. 生成代理类
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(),
                target.getClass().getInterfaces());
        // 3. 创建代理对象
        return  (T)proxyClass.getConstructor(new Class[]{InvocationHandler.class})
                .newInstance(handler);
    }


}
