package com.yuki.jdbc;

import com.yuki.jdbc.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    /*
    * 测试 JdbcTemplate.queryForObject
    * */
    @Test
    public void testQueryForObject() {
        // 1. 查询
        int count = areaService.count();
        // 2. 打印
        System.out.println(count);
    }



    /*
    * 测试RowMapper - 用于映射
    * */
    @Test
    public void testRowMapper() {
        // 1. 查询
        List<Area> count = areaService.queryAreaById();
        // 2. 打印
        System.out.println(count);
    }


    /*
    * 测试 - queryForList
    * */
    @Test
    public void queryForList() {
        List<Map<String, Object>> list = areaService.queryAreaList();
        System.out.println(list);
    }

    /*
    * 更新 - KeyHolder
    * */
    @Test
    @Rollback()
    public void updateKeyHolder() {
        int key = areaService.insert();
        System.out.println(key);
    }

    /*
    * 更新 - batchUpdate
    * */
    @Test
    public void batchUpdate() {
        areaService.batchUpdate();
    }


    @Test
    public void batchUpdate2() {
        areaService.batchUpdate2();
    }

}
