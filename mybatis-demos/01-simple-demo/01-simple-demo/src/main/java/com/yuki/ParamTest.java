package com.yuki;

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
*  @desc ������ͬʱ��mapper�����ʹ�á�
* */
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.DEFAULT) //����˳��ִ��Junit
public class ParamTest extends BaseTest{

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
     * one Param - ʹ��arg0��arg1����param1��param2
     * */
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<Girl> girl = girlDao.queryByNameAndPhone("����","18209876577");
        System.out.println(girl);
    }

    /**
     * pojo Param -ֱ��д������
     * */
    @Test
    public void test3() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl param = new Girl();
        param.setId(1);
        param.setName("����");
        param.setPhone("18209876577");
        List<Girl> girl = girlDao.queryByPojo(param);
        System.out.println(girl);
    }

    /**
     * map param - д��Ӧ��key
     * */
    @Test
    public void test4() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",1);
        map.put("name","����");
        List<Girl> girl = girlDao.queryByMap(map);
        System.out.println(girl);
    }

    /**
     * list param - ʹ��list��ѯ
     * */
    @Test
    public void test5() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<String> list = new ArrayList<String>();
        list.add("����");
        list.add("18209876577");
        List<Girl> girl = girlDao.queryByList(list);
        System.out.println(girl);
    }

    /**
     * list param - ʹ��Set��ѯ
     * */
    @Test
    public void test6() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Set<String> set = new HashSet<String>();
        set.add("����");
        set.add("����ʦ");
        set.add("Angelababy");
        List<Girl> girl = girlDao.queryBySet(set);
        System.out.println(girl);
    }

    /**
     * array param - д��Ӧ��idex
     * */
    @Test
    public void test7() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        String[] arr = new String[2];
        arr[0] = "����";
        arr[1] = "18209876577";
        List<Girl> girl = girlDao.queryByArr(arr);
        System.out.println(girl);
    }
}
