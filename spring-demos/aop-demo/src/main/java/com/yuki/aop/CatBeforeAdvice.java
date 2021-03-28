package com.yuki.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("catBefore")
public class CatBeforeAdvice implements MethodBeforeAdvice {

    // 前置通知
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before - cat准备捕鱼 !!!");
    }
}
