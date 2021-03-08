package com.yuki.entity;

import com.yuki.validate.annotation.ColorCheck;
import lombok.Data;

/*
*  测试 - 自定义 - 校验注解
* */
@Data
public class Cat {

    @ColorCheck(value = {"red","green","blue"})
    private String color;
}
