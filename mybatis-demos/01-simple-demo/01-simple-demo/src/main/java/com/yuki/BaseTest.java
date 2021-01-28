package com.yuki;

import com.yuki.entity.Girl;
import lombok.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/*
* init session
* */
@Data
public class BaseTest {
    SqlSession sqlSession = null;
    {
        // 1. SessionFactoryBuilder + Resources ==> SessionFactory
        Reader config = null;
        try {
            config = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);

        // 2. session = connection
        sqlSession = sessionFactory.openSession();
    }
}
