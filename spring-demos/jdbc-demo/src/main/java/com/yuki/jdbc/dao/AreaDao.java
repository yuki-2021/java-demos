package com.yuki.jdbc.dao;

import com.yuki.jdbc.entity.Area;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* CURD
* */
@Component
public class AreaDao {
    @Autowired
    public AreaDao(DataSource dataSource) {
        this.dataSource = dataSource;
        list = new SqlQueryDao<Area>(dataSource,"select * from tb_area",Area.class);
        query = new SqlQueryDao<Area>(dataSource,"select * from tb_area where id = ?",Area.class);
        insert = new SimpleJdbcInsert(dataSource).withTableName("tb_area").usingGeneratedKeyColumns("id");
        update = new SimpleJdbcInsert(dataSource).withTableName("tb_area");
        delete = new SqlUpdate(dataSource,"delete from tb_area where id =?");
    }


    private DataSource dataSource;
    // 查询 - 列表
    SqlQueryDao<Area> list;
    // 查询 - 单条
    SqlQueryDao<Area> query;
    // 插入
    SimpleJdbcInsert insert;
    // 更改 - 传入id
    SimpleJdbcInsert update;
    // 删除 -
    SqlUpdate delete;
}

class SqlQueryDao<T> extends MappingSqlQuery<T>{

    private Class<T> t;

    public SqlQueryDao(DataSource ds, String sql,Class<T> t) {
        super(ds, sql);
        compile();
        this.t = t;
    }

    @Override
    protected T mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BeanPropertyRowMapper.newInstance(t).mapRow(rs,rowNum);
    }
}
