package com.yuki.redis.service;

import com.yuki.redis.domain.User;

public interface UserService {

    /**
    * 根据id查询用户
    * */
    User findById(Integer id);

    /**
     * 添加用户
     * */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * */
    Integer deleteById(Integer id);
}
