package com.yuki.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component("catAspect")
public class CatAspect {

    // 定义切点
    @Pointcut("execution(* com.yuki.aspect..Cat.*(..))")
    public void catPoint() {}

    // Before Advice
    @Before("catPoint() && args(tool) && @annotation(anno)")
    public void beforeFish(String tool, CatAnno anno) {
        System.out.println("before  - Cat在准备装备!!! -- " + tool + "-----" + anno.values().toString());
    }

    // After throwing
    @AfterThrowing("catPoint()")
    public void afterThrow() {
        System.out.println("throwing - cat捕鱼失败 !!!");
    }

    // after return
    @AfterReturning("catPoint()")
    public void afterReturn() {
        System.out.println("return - Cat捕鱼成功 !!!");
    }

    // After
    @After("catPoint()")
    public void after() {
        System.out.println("after - Cat最后回到了家 !!!");
    }

    // Around
    @Around("catPoint()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around-------------");
        joinPoint.proceed();
        System.out.println("Around-------------");
    }
}
