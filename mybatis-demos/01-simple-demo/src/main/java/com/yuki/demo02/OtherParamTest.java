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
* @desc - nullת����${}��#{}������
*/
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.DEFAULT)
public class OtherParamTest extends BaseTest {

    /*
    *  null -   1. mybaits��TypeHandler �� nullת����jdbcType.OTHER
    *           2. orcale����(orcale��jdbcʵ��)ûʵ��jdbc.OTHER,mysql����ʵ���ˡ�
    *           3. orcale����ִ�лᱨ��
    * */
    @Test
    public void test1() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl param = new Girl();
        // param.setId(1);
        param.setName("����");
        List<Girl> list = girlDao.queryNullCast(param);
        System.out.println(list);
    }


    /*
     *  resultType Pojo - ${} �� #{} ������
     * */
    @Test
    public void test2() {
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<Girl> list = girlDao.queryLikeName("��");
        System.out.println(list);
    }
}
