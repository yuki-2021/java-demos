package com.yuki.datasource.jdbc;

import com.yuki.datasource.jpa.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

/*
*
* 测试 JdbcTemplate和 NamedJdbcTemplate
* */
@SpringBootTest
public class JdbcDaoTest {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private JdbcDao jdbcDao;

    @Test
    public void testJdbc() {
        // 1. repaire param
        Area param = new Area();
        param.setId(3L);
        // 2. test jdbcTemplate
        Area res = namedJdbcTemplate.queryForObject("select * from tb_area where id = :id",
                new BeanPropertySqlParameterSource(param), BeanPropertyRowMapper.newInstance(Area.class));
        // 3. 输出
        System.out.println(res);
    }


    @Test
    public void testDataJdbc() {
        // 1. query
        Optional<JdbcArea> res = jdbcDao.findById(2l);
        // 2. sout
        System.out.println(res.get());
    }
}
