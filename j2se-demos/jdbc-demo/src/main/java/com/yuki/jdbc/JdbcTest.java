package com.yuki.jdbc;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws SQLException {
       /*
       * -------------------------------------------------
       * 1. - 注册驱动 获取连接
       * getConnection()
       * registerDriver()
       * */
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=utf8",
                "root","123456");

        /*
         * -------------------------------------------------
         * 2. Connection - 设置timeout、创建statement、执行事务
         * setTimeout()
         * createStatement() / prepareStatement() / prepareCall()
         * setAutoCommit() / setSavePoint() / rollback() / commit()
         * */
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        conn.setAutoCommit(false);
        statement.executeUpdate("update beauty set name='娜扎8888' where name = '娜扎6666'");
        Savepoint savepoint = conn.setSavepoint();
        conn.rollback(savepoint);
        conn.commit();


        /*
         * -------------------------------------------------
         * 3. Statement - 执行SQL、批量执行、自动关闭
         * executeQuery()  - 执行查询
         * executeUpdate() - 执行DDL,返回0。执行DML，返回影响的row个数。
         * execute()      - 是DQL返回true,然后使用getResultSet()。是DML返回false，然后使用getUpdateCount()。
         * addBatch() / clearBatch() / executeBatch()
         * closeOnAuto
         * */
        ResultSet resultSet = statement.executeQuery("select id,name,phone as ph from beauty");
        if(statement.execute("select count(*) as c from beauty")) {
            ResultSet rs = statement.getResultSet();
            rs.next();
            System.out.println("查询到了" + rs.getInt("c"));
        } else {
            System.out.println(statement.getUpdateCount());
        }
        // 批量更新
        statement.addBatch("insert into beauty(name,phone) values ('girl1','12345678998')");
        statement.clearBatch();
        statement.addBatch("insert into beauty(name,phone) values ('girl2','12345678998')");
        statement.addBatch("insert into beauty(name,phone) values ('girl3','12345678998')");
        int[] ints = statement.executeBatch();
        System.out.println(ints.length);



        /*
         * -------------------------------------------------
         * 4. ResultSet  - 获取数据、执行更新
         *    absolute()、next()、beforeFirst()、first()、previous()、afterLast()、last()
         *    updateRow()
         * */
        resultSet = statement.executeQuery("select id,name,phone as ph from beauty");
        while (resultSet.next()) {
            System.out.printf(resultSet.getString("name"));
            if(resultSet.getString("name").equals("娜扎2")) {
                resultSet.updateString("name","娜扎2222");
            }
            resultSet.updateRow();
        }
        System.out.println();

        /*
         * ResultSetMetaData - 分析查询结果
         *
         * */
        System.out.println("----------- ResultSetMetadata ------------");
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println("表名: " + metaData.getTableName(1));
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String cataLogName = metaData.getCatalogName(i);
            String colName = metaData.getColumnName(i);
            String colTypeName = metaData.getColumnTypeName(i);
            String colLabel = metaData.getColumnLabel(i);
            int colTypeDspSize = metaData.getColumnDisplaySize(i);
            System.out.println(String.format("%s - %s - %s - %s - %d",cataLogName,colName,colLabel,colTypeName,colTypeDspSize));
        }

        /*
        *
        * 执行存储过程 CallableStatement
        *               setXXX()        - 设置参数
        *               registerXXX()   -  注册参数
        * */
        CallableStatement callableStatement = conn.prepareCall("call add_pro(?,?,?)");
        callableStatement.setInt(1,4);
        callableStatement.setInt(2,10);
        callableStatement.execute();
        System.out.println(callableStatement.getInt("sum"));


        // 5. close Jdbc
        closeJdbc(conn, statement, resultSet);
    }

    private static void closeJdbc(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
        // 5. close资源
        resultSet.close();
        statement.close();
        conn.close();
    }

}
