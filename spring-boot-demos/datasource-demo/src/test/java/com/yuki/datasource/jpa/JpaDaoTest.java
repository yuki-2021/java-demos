package com.yuki.datasource.jpa;

import com.yuki.datasource.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.Optional;

@SpringBootTest
@EnableJdbcRepositories
public class JpaDaoTest {

    @Autowired
    private JpaDao jpaDao;

    @Test
    public void testJpa() {
        // 1. query
        Optional<Area> res = jpaDao.findById(2l);
        // 2. sout
        System.out.println(res.get());
    }
}
