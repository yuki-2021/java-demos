package com.yuki.aop;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CatAround implements MethodInterceptor {

    // 环绕Advice
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Around------------------------");
        Object res = invocation.proceed();
        System.out.println("Around------------------------");
        return res;
    }
}
