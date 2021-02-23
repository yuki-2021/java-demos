package com.yuki.demo4;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao{
    public void getProductList() {
        System.out.println("dao - 获取商品列表 !!!");
    }

    public void getProductById() {
        System.out.println("dao - 获取1号商品 !!!");
    }
}
