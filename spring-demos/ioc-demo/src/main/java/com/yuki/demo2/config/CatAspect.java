package com.yuki.demo2.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CatAspect {


    @Before("execution(* com.yuki.demo2.entity.Cat.eat(..))")
    public void beforeEat(JoinPoint joinPoint) {
        System.out.println("cat整理装备 !!!");
    }
}
