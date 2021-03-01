package com.yuki.jackson;

import com.alibaba.fastjson.JSON;
import com.yuki.jackson.entity.Address;
import com.yuki.jackson.entity.Employee;
import com.yuki.jackson.entity.Teacher;

import java.util.Date;

/*
* JSON注解 学习和测试
*
*   @JSONFiled
*       - ordinal 序列化顺序(越大越晚序列化,default 0)
*       - serialize/deserialize - 是否序列化
*       - formatter - 日期格式化
*       - id - obj的字段和str字段的对应关系
 *
* */
public class AnoDemo {

    public static void main(String[] args) {
        // 1. obj -> json
        System.out.println("------------ obj -> str ----------");
        Teacher teacher = new Teacher(1, "yuki", "男", 50, "Java开发",
                2333.33, new Date(), new Address("bj", "xx大厦-203"));
        System.out.println(JSON.toJSONString(teacher));

        // 2. str -> json
        // jobname -> job 测试能否 parse成功
        System.out.println("-----------str -> obj -----------");
        String str = JSON.toJSONString(teacher);
        String str1 = JSON.toJSONString(teacher).replaceAll("jobname","job");
        System.out.println(JSON.parseObject(str,Employee.class)); // faile
        System.out.println(JSON.parseObject(str1,Employee.class)); // sucess
    }
}
