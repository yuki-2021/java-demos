package com.yuki.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.yuki.jackson.entity.Address;
import com.yuki.jackson.entity.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
*   Jackson -
*   1. Jackson概述
*
*      Jackson包括三个包
*      jackson-core - 提供基于流的解析，就是从流中读取，然后产生事件。核心类是JsonGenerator和JsonParser
*      jack-annotation - Jakcson注解
*      jackson-databind - 对jackson-core进一步封装，可以解析json成对象或者json树(类似xml树) - ObjectMapper。JsonNode
*
*   2. 使用demo
*       ObjectMapper
*           - config() - 可以设置DeserializationFeature、SerializationFeature的内容
*           - setSerializationInclusion() - 设置serialization包含字段 - JsonInclude.Include的内容
*           - writerWithDefaultPrettyPrinter() 获取writer
*           - readValue() - 反序列化
*           - getJavaTypeFactory() - 获取JavaType工厂
*       ObjectWriter
*           - writeValueAsString() - pojo写成str
*           - writeValue() - 写成File、Write、OutputStream
*           - writeValueAsByteArray() - 写成byteArray
*       JavaTypeFactory - 构造JavaType
*       TypeReference
*
*       常量
*       DeserializationInclusion - 反序列化配置
*       SerializationInclusion   - 序列化常量
*       JsonInclude.Include      - 配置是否包含
*
*   3. 序列化配置 - 值
*      DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES - str中包含pojo中不存在字段，是否报错
*      SerializationFeature.WRITE_DATES_AS_TIMESTAMPS    -- 指定格式化后的日期是str，而不思timestamp
*      JsonInclude.Include.NON_NULL                      -  序列化时候不包含null
*      JsonInclude.Include.NON_DEFAULT                   -  序列化时忽略default值
*
*  4. Jackson注解
*
*
* */
public class SimpleDemo {

    public static void main(String[] args) throws JsonProcessingException {

        Employee emp = new Employee(1, "yuki", null, 0, "Java开发",
                2333.33, new Date(), new Address("bj", "xx大厦-203"));
        Employee emp1 = new Employee(1, "yuki", null, 0, "Java开发",
                2333.33, new Date(), new Address("bj", "xx大厦-203"));
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(emp);
        emps.add(emp1);



    }

    /*
    *  基础使用
    * */
    private static void serializableTest(Employee emp, List<Employee> emps) throws JsonProcessingException {
        // 1. obj -> str
        String s = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println(s);
        System.out.println("--------------------");

        // 2. str -> obj
        Employee e = new ObjectMapper().readValue(s, Employee.class);
        System.out.println(e);
        System.out.println("--------------------");

        // 3. list -> str
        String empsStr = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(emps);
        System.out.println(empsStr);
        System.out.println("--------------------");

        // 4. str -> list
        ObjectMapper mapper = new ObjectMapper();
        List emplist = mapper.readValue(empsStr, List.class);
        List<Employee> emplist2 = mapper.readValue(empsStr, new TypeReference<List<Employee>>(){});
        JavaType javaType = mapper.getTypeFactory().constructCollectionLikeType(List.class, Employee.class);
        List<Employee> emplist3 = mapper.readValue(empsStr, javaType);
        System.out.println(emplist);
        System.out.println("empList2 =========");
        System.out.println(emplist2);
        System.out.println("empList3 =========");
        System.out.println(emplist3);
        System.out.println("--------------------");

        // 5. str -> Arr(TypeReference、JavaType)
        Employee[] empArr = mapper.readValue(empsStr, new TypeReference<Employee[]>(){});
        Employee[] empArr2 = mapper.readValue(empsStr,
                mapper.getTypeFactory().constructArrayType(Employee.class));
        System.out.println("empArr =========");
        System.out.println(empArr.length);
        System.out.println("empArr2=========");
        System.out.println(empArr2.length);
        System.out.println("--------------------");
    }

    /*
    * 测试Jackson的Objectmappper可以配置那
    *   - configure()、setSerializationInclusion()、setDateFormat()
    *  - DeserializationFeature、SerializationFeature。JsonInclude.Include
    * */
    private static void jackConfigTest(Employee emp) throws JsonProcessingException {
        String str ="{\"id\":1,\"name\":\"yuki\",\"gender\":null,\"age\":0,\"job\":\"Java开发\",\"salary2\":2333.33,\"entryDate\":1614591151073,\"address\":{\"city\":\"bj\",\"addr\":\"xx大厦-203\"}}";

        System.out.println(str);
        // 1. 配置ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                // 反序列化 - 不存在字段 - 是否报错
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                // 序列化 - 日期 - 格式为yyyy-MM-dd'T'HH:mm:ss
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false)
                // 序列化 - null - 忽略
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                // 序列化 - 默认值 - 忽略
                .setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        // 2. 测试Deserialization
        System.out.println("--------DeSerializationFeature 测试 -----");
        Employee employee = objectMapper.readValue(str, Employee.class);
        System.out.println(emp);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp));
    }
}
