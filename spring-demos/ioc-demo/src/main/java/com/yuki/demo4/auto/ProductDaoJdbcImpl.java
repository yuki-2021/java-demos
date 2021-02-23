package com.yuki.demo4.auto;

import com.yuki.demo4.ProductDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoJdbcImpl implements ProductDao {

    public void getProductList() {
        System.out.println("jdbc - 获取product列表 !!!");
    }

    public void getProductById() {
        System.out.println("jdbc - 获取1号商品 !!!");
    }
}
