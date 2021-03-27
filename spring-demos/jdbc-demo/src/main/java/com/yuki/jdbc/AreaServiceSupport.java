package com.yuki.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceSupport extends JdbcDaoSupport  {

    @Autowired
    public AreaServiceSupport(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }

    /*
     * 使用 JdbcDaoSupport
     * */
    public int count() {
        // 1. 查询
        Integer integer = super.getJdbcTemplate().queryForObject("select count(*) from tb_area where id > ?", Integer.class, 1);
        // 2. 返回
        return integer;
    }


}
