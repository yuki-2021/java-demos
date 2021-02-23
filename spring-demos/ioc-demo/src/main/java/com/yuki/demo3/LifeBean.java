package com.yuki.demo3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeBean implements BeanNameAware,ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public LifeBean() {
        System.out.println("step1 -  LifeBean的构造方法" );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("step2 -  调用setXXX方法" );
        this.name = name;
    }

    public void setBeanName(String name) {
        System.out.println("step3 - 调用BeanNameAware的setBeanName" );
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("step4 - ApplicationAware的setAoolicationContext方法" );
    }


    public void afterPropertiesSet() throws Exception {
        System.out.println("step6 - 调用initlizeBean方法afterProperiesSet方法");
    }

    public void init() {
        System.out.println("step7 - 调用init方法");
    }

    public void life() {
        System.out.println("step9 - 调用业务方法life");
    }
    public void destroy() throws Exception {
        System.out.println("step10 - 调用DisposeBean方法destory方法");
    }
    public void des() {
        System.out.println("step11 - 调用des方法");
    }



}
