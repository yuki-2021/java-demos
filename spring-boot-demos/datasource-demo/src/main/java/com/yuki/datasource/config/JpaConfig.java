package com.yuki.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

//@Configuration
public class JpaConfig {

    @Autowired
    private DataSource dataSource;


}
