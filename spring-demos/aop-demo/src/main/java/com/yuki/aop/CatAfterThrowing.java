package com.yuki.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CatAfterThrowing implements ThrowsAdvice {



    // after-return
    public Class<? extends Annotation> annotationType() {
        System.out.println("cat - 捕鱼成功 !!!");
        return null;
    }
}
