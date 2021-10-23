package com.yuki.mvc.param.jsonview_old;

import com.fasterxml.jackson.annotation.JsonView;
import com.yuki.mvc.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/json-view")
@Slf4j
public class JsonViewController {

    @JsonView(Product.DescpView.class)
    @GetMapping("/get")
    public Product getProd() {
        // 1. 打印prod
        Product prod = new Product("aa", "aa", "aa");
        log.info("prod是,prod={}",prod);
        // 2. 返回
        return prod;
    }

}
