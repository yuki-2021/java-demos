package com.yuki.demo03;

import com.yuki.BaseTest;
import com.yuki.dao.GirlDao;
import com.yuki.entity.Girl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Date;


/*
* sqlSession默认不会autoCommit(),也就是默认会rollback()
* 在BaseTest中，使用了 getSession(true)，会自动commit事务
*
* https://blog.csdn.net/f45056231p/article/details/81262035
*/
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class DmlTest extends BaseTest {

    /*
    *  insert 获取主键
    *   - useGenerateKey属性- 使用JDBC驱动获取generateKey
    *   - selectKey 标签
    * */
    @Test

    public void test1() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl = new Girl(null,"哈哈哈","女",
                              new Date(),"12345678911",null,5);
        int status = girlDao.insertGirl(girl);
        System.out.println("插入的状态是:" + status);
        System.out.println(girl);
    }
    
    
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl = new Girl(20,"upgirl","女", new Date(),"12345678911",null,5);
        int status = girlDao.updateGirl(girl);
        System.out.println("更改的状态是:" + status);
        System.out.println(girl);
    }


    @Test
    public void test3() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl = new Girl();
        girl.setId(17);
        int status = girlDao.deleteGirl(girl);
        System.out.println("更改的状态是:" + status);
    }
}
