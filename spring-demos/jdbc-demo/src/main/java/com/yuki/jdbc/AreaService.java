package com.yuki.jdbc;

import com.yuki.jdbc.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* JdbcTemplate
*   queryForObject - 查询单行 Rowmapper - 进行映射
*   update - 进行更新、删除、插入
*   execute() - 执行DDL
*
* */
@Service
public class AreaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 匿名类
    RowMapper<Area> areaMapper = new RowMapper<Area>() {
        public Area mapRow(ResultSet rs, int rowNum) throws SQLException {
            Area area = new Area();
            area.setId(rs.getLong("id"));
            area.setName(rs.getString("name"));
            return area;
        }
    };

    /*
     * queryForObject
     * */
    public int count() {
        // 1. 查询
        Integer integer = jdbcTemplate.queryForObject("select count(*) from tb_area where id > ?", Integer.class, 1);
        // 2. 返回
        return integer;
    }


    /*
     * query - RowMapper
     * */
    public List<Area> queryAreaById() {
        // 1. 查询
        List<Area> area = jdbcTemplate.query("select * from tb_area where id > 1", areaMapper);
        // 2. 返回
        return area;
    }


    /*
     * queryForList - List<Map<key,value>>
     * */
    public List<Map<String,Object>> queryAreaList() {
        // 1. 查询
        final List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_area where id= 1");
        // 2. 返回
        return list;
    }


    /*
     * update - preparedStatementCreator、KeyHolder
     * */
    public int insert() {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("insert into tb_area values(null,'南aa校区',0,?,?)",new String[] {"id"});
                ps.setDate(1, new Date(2021, 1, 1));
                ps.setDate(2, new Date(2021, 1, 1));
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }


    /*
     * batchUpdate - 两种方式 - BatchPreparedStatementSetter
     * */
    public void batchUpdate() {
        final List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        jdbcTemplate.batchUpdate("update tb_area set priority = ? where id = ?", new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1,40);
                ps.setInt(2,idList.get(i));
            }
            public int getBatchSize() {
                return idList.size();
            }
        });
    }


    /*
     * batchUpdate - 两种方式
     * */
    public void batchUpdate2() {
        final List<Object[]> paramList = new ArrayList<Object[]>();
        paramList.add(new Object[]{41,1});
        jdbcTemplate.batchUpdate("update tb_area set priority = ? where id = ?",paramList);
    }
}
