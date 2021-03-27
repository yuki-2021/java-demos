package com.yuki.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaServiceNamedTest {

    @Autowired
    private AreaServiceNamed areaServiceNamed;

    /*
    * 测试 ParamterSource、NamedJdbcTemplate
    * */
    @Test
    public void testParamterSource() {
        // 1. 查询
        areaServiceNamed.insert();
    }


    /*
     * 测试 sqlParamterutils
     * */
    @Test
    public void testSqlParamterSourceUtils() {
        // 1. 查询
        areaServiceNamed.batchUpdate();
    }


}
