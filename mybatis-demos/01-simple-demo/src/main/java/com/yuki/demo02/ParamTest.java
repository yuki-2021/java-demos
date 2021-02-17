package com.yuki.demo02;

import com.yuki.BaseTest;
import com.yuki.dao.GirlDao;
import com.yuki.entity.Girl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.*;

/*
*
*  @desc 参数不同时候，mapper中如何使用。
* */
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.DEFAULT) //声明顺序执行Junit
public class ParamTest extends BaseTest {

    /*
    * one Param - #{value}
    * */
    @Test
    public void test1() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl = girlDao.queryById(1);
        System.out.println(girl);
    }

    /**
     * one Param - 使用arg0、arg1或者param1、param2
     * */
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<Girl> girl = girlDao.queryByNameAndPhone("柳岩","18209876577");
        System.out.println(girl);
    }

    /**
     * pojo Param -直接写属性名
     * */
    @Test
    public void test3() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl param = new Girl();
        param.setId(1);
        param.setName("柳岩");
        param.setPhone("18209876577");
        List<Girl> girl = girlDao.queryByPojo(param);
        System.out.println(girl);
    }

    /**
     * map param - 写对应的key
     * */
    @Test
    public void test4() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",1);
        map.put("name","柳岩");
        List<Girl> girl = girlDao.queryByMap(map);
        System.out.println(girl);
    }

    /**
     * list param - 使用list查询
     * */
    @Test
    public void test5() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<String> list = new ArrayList<String>();
        list.add("柳岩");
        list.add("18209876577");
        List<Girl> girl = girlDao.queryByList(list);
        System.out.println(girl);
    }

    /**
     * list param - 使用Set查询
     * */
    @Test
    public void test6() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Set<String> set = new HashSet<String>();
        set.add("柳岩");
        set.add("苍老师");
        set.add("Angelababy");
        List<Girl> girl = girlDao.queryBySet(set);
        System.out.println(girl);
    }

    /**
     * array param - 写对应的idex
     * */
    @Test
    public void test7() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        String[] arr = new String[2];
        arr[0] = "柳岩";
        arr[1] = "18209876577";
        List<Girl> girl = girlDao.queryByArr(arr);
        System.out.println(girl);
    }

    /*
      多个pojo - @param

     */
    @Test
    public void test8() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl11 = new Girl();
        Girl girl22 = new Girl();
        girl11.setId(1);
        girl22.setName("柳岩");

        List<Girl> list = girlDao.queryByTwoGirl(girl11, girl22);
        System.out.println(list);
    }
}
