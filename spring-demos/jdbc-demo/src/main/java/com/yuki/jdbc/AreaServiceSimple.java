package com.yuki.jdbc;

import com.yuki.jdbc.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AreaServiceSimple {

    @Autowired
    private DataSource dataSource;


    /*
    * 插入
    * withTableName()
    * usingGenderateKeyColumns()
    * execute()
    * executeAndReturnKey()
    * */
    public int insert() {
        // 1. 生成SimpleJdbcInsert
        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("tb_area")
                .usingGeneratedKeyColumns("id");
        // 2. 执行
        HashMap<String, Object> params = new HashMap();
        params.put("name","哈哈哈aa");
        params.put("create_time",new Date());
        params.put("update_time",new Date());
        params.put("priority",1);
        KeyHolder keyHolder = simpleInsert.executeAndReturnKeyHolder(params);
        // 3. 返回
        return keyHolder.getKey().intValue();
    }

    /*
    * 使用SqlParamterSource - 提供参数值
    * */
    public int insertWithiParamSrouce() {
        // 1. 生成SimpleJdbcInsert
        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("tb_area")
                .usingGeneratedKeyColumns("id");
        // 2. 执行
        Area area = new Area();
        area.setPriority(15);
        area.setName("asdasd");
        area.setCreateTime(new Date());
        area.setUpdateTime(new Date());
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(area);
        KeyHolder keyHolder = simpleInsert.executeAndReturnKeyHolder(paramSource);
        // 3. 返回
        return keyHolder.getKey().intValue();
    }


    /*
    * SimpleJdbcCall -
    * */
    public  void executeCall(String[] args) {
        SimpleJdbcCall area_query = new SimpleJdbcCall(dataSource).withProcedureName("area_query");
        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id",1);
        Map<String, Object> res = area_query.execute(paramSource);
    }
}
