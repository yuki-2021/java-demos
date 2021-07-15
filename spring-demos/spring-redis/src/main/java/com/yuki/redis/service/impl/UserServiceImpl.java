package com.yuki.redis.service.impl;

import com.yuki.redis.domain.User;
import com.yuki.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    /**
     * 缓存
     * */
    @Cacheable(key = "#id")
    @Override
//    @Cacheable
    public User findById(Integer id) {
        // 1. 查询
        log.info("根据id查询用户,id={}",id);
        User user = new User(String.valueOf(id), String.valueOf(id));
        log.info("根据id查询用户,res={}",user);

        // 2. 返回
        return user;
    }


    /**
     * 更新缓存
     * */
    @CachePut(key = "#user.id")
    @Override
    public User saveOrUpdateUser(User user) {
        // 1. 更新
        log.info("更新用户，user={}",user);
        log.info("更新用户成功，res={}",user);


        // 2. 返回
        return user;
    }

    /**
     * 删除缓存
     * */
    @CacheEvict(key = "#id")
    @Override
    public Integer deleteById(Integer id) {
        // 1. 更新
        log.info("删除用户，id={}",id);
        log.info("删除用户成功，res={}",id);

        // 2. 返回
        return id;
    }
}
