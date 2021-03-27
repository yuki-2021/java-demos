package com.yuki.jdbc;

import com.yuki.jdbc.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* NamedJdbcTemplate
*
*
*
* */
@Service
public class AreaServiceNamed {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;


    /*
     * update - 可以接收Map和SqlParamterSource、MapSqlParamterSource、BeanPropertySqlParamterSource
     * */
    public void insert() {
        Area area = new Area();
        area.setId(1l);
        area.setPriority(12);
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(area);
        namedJdbcTemplate.update("update tb_area set priority=:priority where id = :id",paramSource);
    }


    /*
    * 批量更新 - 测试SqlParamterUtils、SqlParamterSource
    * */
    public void batchUpdate() {
        Area area1 = new Area();
        Area area2 = new Area();
        area1.setId(1l);
        area1.setPriority(13);
        area2.setId(2l);
        area2.setPriority(13);
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(new Object[]{area1,area2});
        namedJdbcTemplate.batchUpdate("update tb_area set priority=:priority where id = :id",batch);
    }
}
