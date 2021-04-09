package com.yuki.embed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
public class EmbedDatasourceApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(EmbedDatasourceApplication.class, args);

        // MARk 1. 测试 - spring-data-jap 查看配置之什么驱动 - 需要引入nosql到路径中
        DataSource datasource = context.getBean(DataSource.class);
        System.out.println(datasource);
    }
}
