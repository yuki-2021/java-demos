package com.yuki.jdbc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaServiceSupportTest {

    @Autowired
    private AreaServiceSupport areaServiceSupport;

    @Test
    public void testQueryForObject() {
        System.out.println(areaServiceSupport.count());
    }
}
