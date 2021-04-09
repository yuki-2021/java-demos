package com.yuki.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
public class DatasourceApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(DatasourceApplication.class, args);

        // MARk 1. 测试 - 只引入了mysql驱动。会配置什么Datasource - 报错，找不到实现类
        DataSource datasource = context.getBean(DataSource.class);
        System.out.println(datasource);
    }

}
