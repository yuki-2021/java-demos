package com.yuki.mvc.param.cookie_old;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
/**
 * 测试@CookieValue
 * */
@Slf4j
public class CookieController {

    // 设置Cookie - 设置JSESSIONID
    @GetMapping("/set")
    public String setCookie(HttpSession session) {
        log.info("=====================");
        log.info("设置JSESSIONID成功");
        log.info("=====================");
        return "设置JSESSIONID成功";
    }

    // 获取Cookie - 使用@CookieValue来获取Cookie
    @GetMapping("/get")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId) {
        log.info("=====================");
        log.info("JSESSIONID={}",sessionId);
        log.info("=====================");
        return sessionId;
    }

    // 不存在的Cookie
    @GetMapping("/null")
    public String nullCookie(@CookieValue("aaa") String aaa) {
        log.info("=====================");
        log.info("aaa={}",aaa);
        log.info("=====================");
        return aaa;
    }


}
