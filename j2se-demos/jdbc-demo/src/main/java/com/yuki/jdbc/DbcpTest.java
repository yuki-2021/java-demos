package com.yuki.jdbc;

import com.sun.rowset.JdbcRowSetImpl;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;


public class DbcpTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

        // 1. DataSource
        BasicDataSource basicDataSource = new BasicDataSource();

        // 2. set params
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        basicDataSource.setMinIdle(2);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxActive(50);

        // 3. 获取连接
        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl(basicDataSource.getConnection());
        jdbcRowSet.setCommand("select count(*) as c from beauty");
        jdbcRowSet.execute();

        // 4. 输出
        jdbcRowSet.next();
        int c = jdbcRowSet.getInt("c");
        System.out.println(c);
    }

}
