package com.yuki.demo02;

import com.yuki.BaseTest;
import com.yuki.dao.GirlDao;
import com.yuki.entity.Girl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Map;

/*
* @desc - resultType 指定返回值类型
*/
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.DEFAULT)
public class ResTest extends BaseTest {

    /*
    *  resultType Map - resultSet映射成Map类型
    * */
    @Test
    public void test1() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Map<String, Object> map = girlDao.queryMap(1);
        System.out.println(map);
    }

    /*
     *  resultType Pojo - resultSet映射成Pojo类型
     * */
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl = girlDao.queryPojo(1);
        System.out.println(girl);
    }
}
