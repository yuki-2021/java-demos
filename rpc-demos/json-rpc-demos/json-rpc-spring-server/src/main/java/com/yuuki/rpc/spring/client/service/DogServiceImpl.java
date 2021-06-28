package com.yuuki.rpc.spring.client.service;

import com.yuki.rpc.api.DogService;
import com.yuki.rpc.entity.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DogServiceImpl implements DogService {

    public Dog findDogById(String name) {
        log.info("根据id查询Dog,参数是：{}",name);
        Dog dog = new Dog(name, name);
        log.info("根据id查询Dog,结果是：{}",dog);
        return dog;
    }
}
