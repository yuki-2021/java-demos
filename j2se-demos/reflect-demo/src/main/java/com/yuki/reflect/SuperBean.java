package com.yuki.reflect;


import javax.annotation.Resource;

@Resource
public class SuperBean {

    public String name = "super";
    public int age;

    public void eat() {
        System.out.println("animal eat !!!");
    }

    private void drink() {
        System.out.println("animal drink !!!");
    }

}
