package com.yuki.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class CatAfterReturn implements AfterReturningAdvice {

    // after-return
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("cat - 捕鱼成功 !!!");
    }
}
