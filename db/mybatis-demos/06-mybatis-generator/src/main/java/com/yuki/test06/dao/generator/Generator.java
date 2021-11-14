package com.yuki.test06.dao.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* 生成
* */
class Generator {

    /*
    * 警告列表
    * */
    private static List<String> warningList = new ArrayList<>();

    /*
    * 覆盖已有代码
    * */
    private static Boolean overwrite = true;

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {

        // 1. 使用ConfigurationParser解析xml配置
        InputStream resource = Generator.class.getResourceAsStream("/mybatis-generator-config.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warningList);
        Configuration configuration = configurationParser.parseConfiguration(resource);
        resource.close();

        // 2. 创建MybatisGenerator，并生成代码
        MyBatisGenerator mybatisGenerator
                = new MyBatisGenerator(configuration,new DefaultShellCallback(overwrite),warningList);
        mybatisGenerator.generate(null);
        for (String warning : warningList) {
            System.out.println(warning);
        }

    }
}
