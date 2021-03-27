package com.yuki.jdbc.dao;

import com.yuki.jdbc.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQuery() {
        List<Area> execute = areaDao.list.execute();
        System.out.println(execute);
    }
}
