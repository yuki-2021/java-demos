package com.yuki.test081;

import com.yuki.test081.dao.EmployeeDao;
import com.yuki.test081.dao.SimpleDao;
import com.yuki.test081.domain.Employee;
import com.yuki.test081.domain.Simple;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.store.DiskStoreBootstrapCacheLoader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

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
    * 集成Ehcache
    *
    * - 是否生效
    * */
    @Test
    public void testEhcache() throws IOException, InterruptedException {

        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);


        // 放入缓存
        log.info("---------- 放入缓存 ------------");
        employeeDao.getEmpById(12);
        sqlSession.close();

        // 新的sqlSession
        log.info("---------- 新的sqlSession ------------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.getEmpById(12);
    }

    /*
     * 集成Ehcache
     *
     * - 是否生效
     * */
    @Test
    public void testEhcacheFlush() throws IOException, InterruptedException {

        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);


        // 放入缓存
        log.info("---------- 放入缓存 ------------");
        employeeDao.getEmpById(12);
        employeeDao.getEmpByDeptId(1);
        sqlSession.close();

//        // 新的sqlSession
//        log.info("---------- 更新数据 ------------");
//        sqlSession = getSqlSession();
//        employeeDao = sqlSession.getMapper(EmployeeDao.class);
//        employeeDao.insertFlush(new Employee(null,"new","男","tt@163.com"));
//        sqlSession.close();

        // 新的sqlSession
        Thread.sleep(2000);
        log.info("---------- 新的sqlSession ------------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.getEmpById(12);
        employeeDao.getEmpByDeptId(1);
    }


    /*
     * 集成Ehcache
     *
     * - 是否生效
     * */
    @Test
    public void testEhcacheFlushNs() throws IOException, InterruptedException {

        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);


        // 放入缓存
        log.info("---------- 放入缓存 ------------");
        employeeDao.getEmpById(12);
        simpleDao.getSimpleById(1);
        sqlSession.close();

        // 新的sqlSession
        log.info("---------- 更新数据 ------------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.insertFlush(new Employee(null,"new","男","tt@163.com"));
        sqlSession.close();

        // 新的sqlSession
        log.info("---------- 新的sqlSession ------------");
        sqlSession = getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
        simpleDao = sqlSession.getMapper(SimpleDao.class);
        employeeDao.getEmpById(12);
        simpleDao.getSimpleById(1);
    }

}