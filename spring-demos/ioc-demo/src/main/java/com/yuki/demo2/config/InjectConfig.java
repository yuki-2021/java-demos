package com.yuki.demo2.config;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.yuki.demo2.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;


import java.util.Arrays;


@Configuration
@EnableAspectJAutoProxy
public class InjectConfig {

    @Bean
    public Car car1() {
        Car car = new Car();
        car.setColor("red");
        car.setBrand("byd");
        return car;
    }

    @Bean
    public Employee emp1() {
        Employee employee = new Employee();
        // 这里注入了Car 判断是不是Car1
        employee.setCar(car1());
        employee.setId(1);
        employee.setName("jack");
        Department dept = new Department("开发部", "xx大厦-B102");
        employee.setDept(dept);
        return employee;
    }


    @Bean
    public Cat cat1() {
        return new Cat("悠米",12,"red");
    }

    @Bean
    public Cat cat2() {
        return new Cat("悠米",12,null);
    }

    @Bean
    public CollectBean collect() {
        CollectBean collectBean = new CollectBean();
        collectBean.setList(Arrays.asList("Java","C#","PHP"));
        collectBean.setArr(new String[]{"A","B","C"});
        return collectBean;
    }



    @Bean
    public CatAspect catAspect() {
        return new CatAspect();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Cat catPrototype() {
        Cat cat = new Cat();
        return cat;
    }


}
