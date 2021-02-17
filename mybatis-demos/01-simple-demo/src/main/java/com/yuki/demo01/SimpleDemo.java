package com.yuki.demo01;

import com.yuki.entity.Girl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@RunWith(JUnit4.class)
public class SimpleDemo {

    @Test
    public void simpleDemo() {
        // 1. SessionFactoryBuilder + Resources ==> SessionFactory
        Reader config = null;
        try {
            config = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);

        // 2. session = connection
        SqlSession sqlSession = sessionFactory.openSession();

        // 3. 获取dao的动态代理
//        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
//        List<Girl> list = girlDao.queryGirlList();

        List<Girl> list = sqlSession.selectList("com.yuki.dao.GirlDao.queryGirlList", Girl.class);

        // 4. 输出结果
        System.out.println("total is :" + list.size());
        for (Girl girl : list) {
            System.out.println(girl);
        }
    }
}
