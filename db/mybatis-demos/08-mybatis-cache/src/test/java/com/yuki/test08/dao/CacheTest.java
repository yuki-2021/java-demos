package com.yuki.test08.dao;

import com.yuki.test08.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class CacheTest {

    private static Logger log = Logger.getLogger(CacheTest.class);


    private SqlSessionFactory sqlSessionFactory;

    /*
    * SqlSessionFactory
    * */
    private SqlSessionFactory initSqlSesionFactory() throws IOException {
        // 有 -> 返回
        if(sqlSessionFactory != null) {
            return sqlSessionFactory;
        }
        // 没有 -> 创建
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        return sqlSessionFactory;
    }


    /*
    * Dao对象
    * */
    private <T> T getDaoByClass(Class<T> clazz) throws IOException {
        SqlSession sqlSession = getSqlSession();
        return  sqlSession.getMapper(clazz);
    }


    /*
     * SqlSession
     * */
    private SqlSession getSqlSession() throws IOException {
        // 1. 初始化sqlSessionFactory
        initSqlSesionFactory();
        // 2. 创建SqlSession
        return sqlSessionFactory.openSession(true);
    }

    /*
    * 一级缓存
    *
    * - 是否生效
    * - 缓存是sqlSession范围的
    * */
    @Test
    public void testOneLevelCacheScope() throws IOException {
        // 测试 - 一级缓存是否生效
        EmployeeDao employeeDao = getDaoByClass(EmployeeDao.class);

        // 测试 - 一级缓存是否生效和范围
        log.info("---------- 一级缓存是否生效 --------------");
        List<Employee> employeeList = employeeDao.getOneLevelCacheById(12);
        List<Employee> employeeLis2 = employeeDao.getOneLevelCacheById(12);
        log.info(employeeList == employeeLis2);

        // 测试 - 一级缓存的范围是sqlSession的范围
        log.info("---------- 一级缓存是sqlSession级别的 --------------");
        EmployeeDao employeeDaoNew = getDaoByClass(EmployeeDao.class);
        List<Employee> employeeListNew = employeeDaoNew.getOneLevelCacheById(12);
        log.info(employeeList == employeeListNew);
    }

    /*
     * 一级缓存
     *
     * - flushCache清除的所有缓存
     * - insert、update、delete 清除所有缓存
     * */
    @Test
    public void testOneLevelCacheFlushCache() throws IOException {
        // 测试 - 一级缓存是否生效
        EmployeeDao employeeDao = getDaoByClass(EmployeeDao.class);

        // 初始化缓存内容
        log.info("-------------  创建缓存    ---------");
        employeeDao.getOneLevelCacheById(12);
        employeeDao.getOneLevelCacheByDeptId(1);

        // 清除
        log.info("-------------  flushCache清除缓存   ---------");
        employeeDao.insertFlush(new Employee(null,"new","男","tt@163.com"));

        //  查看是否被清除
        log.info("------------- 查看是否清除 ---------");
        employeeDao.getOneLevelCacheByDeptId(1);
    }


    /*
     * 二级缓存
     *
     * - sqlSession.close() 会把缓存放到二级缓存中
     * */
    @Test
    public void testTwoLevelCache() throws IOException {
        // 1. 创建sqlSession，并且放入一级缓存
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

        // 缓存
        // 放入二级缓存
        log.info("--------- 放入一级缓存 ---------");
        employeeDao.getTwoCacheLevelById(12);
        employeeDao.getTwoCacheLevelById(12);
        log.info("--------- 同步到二级缓存 ---------");
        sqlSession.close();


        // 访问二级缓存
        log.info("--------- 创建新的SqlSession ---------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.getTwoCacheLevelById(12);
        employeeDao.getTwoCacheLevelById(12);
    }


    /*
     * 二级缓存
     * - insert、update、delete会清空缓存
     * - flushInterval 会清空缓存
     * - 当达到最大大小，会按照eviction来更新缓存
     * */
    @Test
    public void testTwoLevelCacheFlush() throws IOException, InterruptedException {
        // 1. 创建sqlSession，并且放入一级缓存
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

        // 更新二级缓存
        log.info("--------- 放入一级缓存 ---------");
        employeeDao.getTwoCacheLevelById(12);
        employeeDao.getOneLevelCacheByDeptId(1);
        log.info("--------- 同步到二级缓存 ---------");
        sqlSession.close();


        // 清空缓存
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.insertFlush(new Employee(null,"new","男","tt@163.com"));
        sqlSession.close();


        // 查看缓存中是否有内容
        log.info("--------- 缓存中是否有内容 ---------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.getTwoCacheLevelById(12);
        employeeDao.getOneLevelCacheByDeptId(1);
    }


    /*
     * 二级缓存
     * - 多个Namespace
     * */
    @Test
    public void testTwoLevelCacheNamespaces() throws IOException, InterruptedException {
        // 1. 创建sqlSession，并且放入一级缓存
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);

        // 更新二级缓存
        log.info("--------- 放入一级缓存 ---------");
        employeeDao.getTwoCacheLevelById(12);
        simpleDao.getSimpleById(1);
        log.info("--------- 同步到二级缓存 ---------");
        sqlSession.close();


        // 清空缓存
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.insertFlush(new Employee(null,"new","男","tt@163.com"));
        sqlSession.close();


        // 查看缓存中是否有内容
        log.info("--------- 缓存中是否有内容 ---------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        simpleDao = sqlSession.getMapper(SimpleDao.class);
        employeeDao.getTwoCacheLevelById(12);
        simpleDao.getSimpleById(1);
    }

}