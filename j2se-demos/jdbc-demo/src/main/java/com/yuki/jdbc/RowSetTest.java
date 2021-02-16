package com.yuki.jdbc;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.lang.reflect.Method;
import java.sql.*;

/*
*
*   setUrL()  / setUsername() / setPassword() / setCommand() / execute() - 设置SQL语句填充RowSet
*   populate() - 包装ResultSet
*
*   离线RowSet - 解决了Result数据到Map,然后再传到View中的问题
*
*   RowSet分页
*
* */
public class RowSetTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        cachedRowsetPage();
    }

    private static void jdbcRowsetTest() throws ClassNotFoundException, SQLException   {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 3. 创建在线RowSet
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8");
        jdbcRowSet.setUsername("root");
        jdbcRowSet.setPassword("123456");

        // 4. 执行查询
        jdbcRowSet.setCommand("select * from beauty");
        jdbcRowSet.execute();

        // 5. 遍历RowSet
        while (jdbcRowSet.next()) {
            System.out.println(jdbcRowSet.getString("name"));
        }

        // 6. 更新数据
        jdbcRowSet.setAutoCommit(false);
        jdbcRowSet.previous();
        jdbcRowSet.updateString("name","哪哈");
        jdbcRowSet.updateRow(); // 相当于调用executeUpdate()
        jdbcRowSet.commit();
    }

    private static void cachedRowsetTest() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 创建 离线Rowset
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);

        // 3. 查询
        cachedRowSet.setCommand("select * from beauty");
        cachedRowSet.execute();


        // 4. 本地更新
        cachedRowSet.last();
        cachedRowSet.updateString("name","哪哈D");
        cachedRowSet.updateRow();

        // 5. 同步远程
        Connection conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        cachedRowSet.acceptChanges(conn);

        // 6. 关闭资源
        conn.close();
        cachedRowSet.close();

    }


    private static void cachedRowsetPage() throws ClassNotFoundException, SQLException   {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 创建RowSet
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl("jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8");
        cachedRowSet.setUsername("root");
        cachedRowSet.setPassword("123456");

        // 3 设置分页
        cachedRowSet.setPageSize(2);

        // 4. 执行查询
        cachedRowSet.setCommand("select * from beauty");
        cachedRowSet.execute();

        // 5. 输出第一页
        printResultSet(cachedRowSet);

        // 6. 输出其他页
        while (cachedRowSet.nextPage()) {
            printResultSet(cachedRowSet);
            System.out.println("-----------");
        }
    }

    private static void printResultSet(CachedRowSet cachedRowSet) throws SQLException {
        while (cachedRowSet.next()) {
            System.out.println(cachedRowSet.getString("name"));
        }
    }

}
