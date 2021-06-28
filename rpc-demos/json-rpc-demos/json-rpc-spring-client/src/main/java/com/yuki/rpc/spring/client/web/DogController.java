package com.yuki.rpc.spring.client.web;

import com.yuki.rpc.api.DogService;
import com.yuki.rpc.entity.Dog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
@Slf4j
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;


    @GetMapping("/{name}")
    public Dog dog(@PathVariable String name) {
        // 1. 调用rpc
        log.info("调用rpc,参数是：{}", name);
        Dog res = dogService.findDogById(name);
        log.info("调用rpc,结果是：{}", res);

        // 2. 返回
        return res;
    }


}
