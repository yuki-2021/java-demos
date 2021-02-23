package com.yuki.demo2.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Cat {
    private String name;
    private int age;
    private String color;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("cat-name-age- 构造函数");
    }

    public Cat(int age, String name) {
        this.name = name;
        this.age = age;
        System.out.println("cat-age-name- 构造函数");
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat(int age, String name, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat() {
        System.out.println("cat init !!!");
    }

    public void eat() {
        System.out.println("cat正在觅食 !!!");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
