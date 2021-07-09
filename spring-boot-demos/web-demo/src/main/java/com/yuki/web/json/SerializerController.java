package com.yuki.web.json;

import com.yuki.web.entity.Product;
import com.yuki.web.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/*
* SerializerController - 测试@JsonCompnent
* */
@RestController
@RequestMapping("/serializer")
@Slf4j
public class SerializerController {


    /*
    * 根据json串查询Product
    * */
    @PostMapping
    public Product getProduct(@RequestBody Product product) {
        log.info("查询Product,参数product= {} ", product);
        return product;
    }

}
