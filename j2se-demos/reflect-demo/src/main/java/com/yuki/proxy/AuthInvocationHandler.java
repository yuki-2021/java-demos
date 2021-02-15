package com.yuki.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
* AuthInvocationHandler - 横切逻辑 和 目标类
*
* */
public class AuthInvocationHandler implements InvocationHandler {

    private Object target;
    public AuthInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------身份验证成功--------");
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
