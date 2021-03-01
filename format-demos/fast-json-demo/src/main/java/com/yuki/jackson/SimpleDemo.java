package com.yuki.jackson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuki.jackson.entity.Address;
import com.yuki.jackson.entity.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
*   FastJSON 测试和学习
*
*   JSON对象
*       - toJSONString()  对象(obj、arr) -> str
*       - parse()/parseObj()/parseArr() str->对象(arr/obj)
*       - parse() 不支持泛型
* */
public class SimpleDemo {

    public static void main(String[] args) {
        /*
         *   FastJSON 测试和学习
         *
         *   JSON对象
         *       - toJSONString()  对象(obj、arr) -> str
         *       - parse()/parseObj()/parseArr() str->对象(arr/obj)
         *       - parse() 不支持泛型
         * */
        Employee emp = new Employee(1, "yuki", "男", 50, "Java开发",
                2333.33, new Date(), new Address("bj", "xx大厦-203"));
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1, "yuki", "男", 11, "Java开发1",
                1333.33, new Date(), new Address("bj", "xx大厦-111")));
        emps.add(new Employee(2, "yuki2", "男", 22, "Java开发2",
                2333.33, new Date(), new Address("bj2", "xx大厦-222")));

        // 1. obj -> json
        String str = JSON.toJSONString(emp);
        System.out.println(str);
        System.out.println("---------------------");

        // 2. obj -> json
        JSONObject emp1 = JSON.parseObject(str);
        System.out.println(emp1);
        System.out.println("---------------------");


        // 3. List -> json
        String strArr = JSON.toJSONString(emps);
        System.out.println(strArr);
        System.out.println("---------------------");


        // 4. json -> List
        List<Employee> empList = JSON.parseArray(strArr,Employee.class);
        System.out.println(empList);
        System.out.println("---------------------");
    }
}
