package com.yuki.datasource.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
* @Author 配置 Datasource
* */
@Configuration
public class DatasourceConfig {

    // Mark 3. 手动指定DataSource - 使用了DatasourceBuilder
    /*
    * DatasourceBuilder - 构造者模式
    *   - create() - 创建builder
    *   - type() - 指定数据源类型
    *   - driverClassName()、url()、username()、password() -配置datasource
    *   - builder() - 构建datasource
    * */
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create()// 创建Builder
                .type(org.springframework.jdbc.datasource.SimpleDriverDataSource.class)// 指定Datasource类型
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://127.0.0.1:3306/laifu?useUnicode=true&characterEncoding=utf8")
                .username("root")
                .password("123456")
                .build();
        return dataSource;
    }
}
