package com.yuki.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DatasourceApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(DatasourceApplication.class, args);

        // MARK  1. 测试默认的Datasource类型
        System.out.println("==========================");
        DataSource datasource = context.getBean(DataSource.class);
        System.out.println(datasource);

        // 2. 测试JdbcTemplate是否存在
        System.out.println("==========================");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

}
