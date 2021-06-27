package com.yuki.rpc.stream.service;

import com.yuki.rpc.api.UserService;
import com.yuki.rpc.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {


    public User findUserById(String name) {
        log.info("根据id查询User,参数是：{}",name);
        User user = new User(name, name);
        log.info("根据id查询User,结果是：{}",user);
        return user;
    }
}
