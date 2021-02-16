package com.yuki.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.rowset.JdbcRowSetImpl;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class C3P0Test {

    public static void main(String[] args) throws PropertyVetoException, SQLException {
        String url = "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

        // 1. init datasource
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);

        comboPooledDataSource.setMaxPoolSize(30);
        comboPooledDataSource.setMinPoolSize(10);
        comboPooledDataSource.setInitialPoolSize(20);
        comboPooledDataSource.setMaxStatements(180);

        // 3. 获取连接
        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl(comboPooledDataSource.getConnection());
        jdbcRowSet.setCommand("select count(*) as c from beauty");
        jdbcRowSet.execute();

        // 4. 输出
        jdbcRowSet.next();
        int c = jdbcRowSet.getInt("c");
        System.out.println(c);
    }
}
