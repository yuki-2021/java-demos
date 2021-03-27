package com.yuki.jdbc;

import com.yuki.jdbc.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Service
public class AreaServiceMap {

    @Autowired
    private DataSource dataSource;





    /*
    * 查询
    * */
    public List queryList() {
        // 1. 执行查询
        MappingSqlQuery mappingSqlQuery = new MappingSqlQuery<Area>(dataSource,"select * from tb_area where id > 1") {
            protected Area mapRow(ResultSet rs, int rowNum) throws SQLException {
                return BeanPropertyRowMapper.newInstance(Area.class).mapRow(rs,rowNum);
            }

        };
        List list = mappingSqlQuery.execute();
        // 2. 返回列表
        return list;
    }

    /*
    * 更新 -
    * */
    public void updateById() {
        SqlUpdate sqlUpdate = new SqlUpdate(dataSource, "update tb_area set priority=? where id =?");
        sqlUpdate.declareParameter(new SqlParameter("priority",Types.NUMERIC));
        sqlUpdate.declareParameter(new SqlParameter("id",Types.NUMERIC));
        sqlUpdate.compile();
        int update = sqlUpdate.update(48, 1);
    }

}

