package com.yuki.mvc.param.cookie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @SessionAttr来取Session中的属性
 * */
@Slf4j
public class SessionAttrController {

    /**
     * 设置Session
     * */
    @GetMapping("/set")
    public String setSession(HttpSession session) {
        log.info("=====================");
        session.setAttribute("username","yuki");
        log.info("设置Session的成功。key={},value={}","username","yuki");
        log.info("=====================");
        return "设置Session的成功";
    }

    /**
     * 获取Session - 使用@SessionAttribute来获取Cookie
     * */
    @GetMapping("/get")
    public String getSession(@SessionAttribute("username") String username) {
        log.info("=====================");
        log.info("获取Session,值是：{}",username);
        log.info("=====================");
        return username;
    }

    /**
     * 不存在的Session
     * */
    @GetMapping("/null")
    public String nullSession(@CookieValue("password") String password) {
        log.info("=====================");
        log.info("获取Session,值是：{}",password);
        log.info("=====================");
        return password;
    }

    /**
     * 修改Session
     * */
    @GetMapping("/change")
    public String updateSession(@SessionAttribute("username") String username) {
        log.info("=====================");
        username = "changed";
        log.info("修改Session,值是：{}",username);
        log.info("=====================");
        return username;
    }
}
