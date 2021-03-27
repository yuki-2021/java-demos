package com.yuki.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaServiceSimpleTest {

    @Autowired
    private AreaServiceSimple areaServiceSimple;

    /*
    * 测试SimpleJdbcInsert - 插入数据
    * withTableName()
    * usingGenderateKeyColumns()
    * execute()
    * executeAndReturnKeyHolder()
    * */
    @Test
    @Rollback
    public void insert() {
        int insert = areaServiceSimple.insert();
        System.out.println(insert);
    }


    @Test
    @Rollback
    public void insertWithParamSource() {
        int insert = areaServiceSimple.insertWithiParamSrouce();
        System.out.println(insert);
    }
}
