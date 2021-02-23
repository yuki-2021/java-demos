package com.yuki.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService{

    @Value("version-1.0.0")
    private String version;

    @Resource(name = "productDaoJdbcImpl")
    private ProductDao productDao;


    public void getProducts() {
        productDao.getProductList();
        System.out.println(version);
        System.out.println("service - 获取商品列表 !!!");
    }

    public void getProductById() {
        productDao.getProductById();
        System.out.println("service - 获取1号商品 !!!");
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
