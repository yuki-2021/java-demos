package com.yuki.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class XmlService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /*
     * 使用事务 - @Transitional
     * */
    public void insert() {
        // 1. 插入数据
        int update = jdbcTemplate.update("insert into tb_area value (null,'西校区')");
        // 2. 抛出异常
        throw new RuntimeException("出现了错误");
        // 3. 查看是否回滚
    }
}
