package com.yuki.redis.web;

import com.yuki.redis.domain.User;
import com.yuki.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询User
     */
    @GetMapping("/{id}")
    public User findById( Integer id) {
        // 1. 查询
        log.info("根据id查询用户,id={}",id);
        User res = userService.findById(id);
        log.info("根据id查询用户,res={}",res);

        // 2. 返回
        return res;
    }


    /**
     * 更新User
     * */
    @PostMapping
    public User saveOrUpdateUser(@RequestBody User user) {
        // 1. 更新
        log.info("更新用户，user={}",user);
        User res = userService.saveOrUpdateUser(user);
        log.info("更新用户成功，res={}",res);

        // 2. 返回
        return res;
    }

    /**
     * 根据id删除用户
     * */
    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable Integer id) {
        // 1. 删除
        log.info("删除用户，id={}",id);
        Integer res = userService.deleteById(id);
        log.info("删除用户成功，res={}",res);

        // 2. 返回
        return res;
    }
}
