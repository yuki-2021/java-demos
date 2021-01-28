package com.yuki.demo02;

import com.yuki.BaseTest;
import com.yuki.dao.GirlDao;
import com.yuki.entity.Girl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Map;

/*
* @desc - null转化、${}和#{}的区别
*/
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.DEFAULT)
public class OtherParamTest extends BaseTest {

    /*
    *  null -   1. mybaits用TypeHandler 把 null转换成jdbcType.OTHER
    *           2. orcale驱动(orcale的jdbc实现)没实现jdbc.OTHER,mysql驱动实现了。
    *           3. orcale驱动执行会报错。
    * */
    @Test
    public void test1() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl param = new Girl();
        // param.setId(1);
        param.setName("柳岩");
        List<Girl> list = girlDao.queryNullCast(param);
        System.out.println(list);
    }


    /*
     *  resultType Pojo - ${} 和 #{} 的区别
     * */
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<Girl> list = girlDao.queryLikeName("周");
        System.out.println(list);
    }
}
