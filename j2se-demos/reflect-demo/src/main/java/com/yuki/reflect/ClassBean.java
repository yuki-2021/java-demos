package com.yuki.reflect;

import java.io.Serializable;

@SuppressWarnings(value = "ubchecked")
@Deprecated
public class ClassBean extends SuperBean implements Serializable {

    private String name = "aaa";

    private ClassBean() {}

    public ClassBean(String name) {
        System.out.println("公用构造函数 !!!");
    }

    public void info() {
        System.out.println("info !!!");
    }

    private void sayHellow() {
        System.out.println("hello !!!");
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
