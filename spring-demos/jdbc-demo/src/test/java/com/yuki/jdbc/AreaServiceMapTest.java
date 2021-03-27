package com.yuki.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaServiceMapTest {


    @Autowired
    private AreaServiceMap areaServiceMap;

    /*
    * areaServiceMap -
    * */
    @Test
    public void testSqlQuery() {
        List list = areaServiceMap.queryList();
        System.out.println(list);
    }


    /*
     * areaServiceMap -
     * */
    @Test
    public void testSqlUpdate() {
         areaServiceMap.updateById();
    }
}
