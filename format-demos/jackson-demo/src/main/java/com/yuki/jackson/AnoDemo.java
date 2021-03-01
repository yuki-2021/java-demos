package com.yuki.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuki.jackson.entity.Address;
import com.yuki.jackson.entity.Employee;
import com.yuki.jackson.entity.Teacher;

import java.util.Date;

/*
* JSON注解  - 学习和测试
*
*  @JsonInclude - 设置include
*  @JsonProperty - filed和str对应关系
*  @JsonFormat   - date格式化
*  @JsonPropertyOrder - 设置field顺序
 *
* */
public class AnoDemo {

    public static void main(String[] args) throws JsonProcessingException {
        Teacher teacher = new Teacher(1, "yuki", null, 50, "Java开发",
                2333.33, new Date(), new Address("bj", "xx大厦-203"));


        // 1. pojo -> str
        String s = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(teacher);
        System.out.println(s);
    }
}
