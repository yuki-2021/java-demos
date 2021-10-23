package com.yuki.mvc.param.cookie;


import com.yuki.mvc.entity.Dog;
import com.yuki.mvc.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


/*
*
*  测试 - 没有HttpSession，是否可以使用@SessionAttributes
*        1. http://localhost:8080/user-session/create - 创建HttpSession
*        2. http://localhost:8080/user-session/add?name=add&password=add - 创建SessionAttr
*        3. http://localhost:8080/user-session/show - 查看
*
*  测试 - 修改
*        1. http://localhost:8080/user-session/change?name=change&password=change - 修改SessionAttr
*        2. http://localhost:8080/user-session/show - 查看
*
*  测试 - 另外Controller是否可以访问
*        1. http://localhost:8080/user-session/create - 创建HttpSession
*        2. http://localhost:8080/user-session/add?name=add&password=add - 创建SessionAttr
*        3. http://localhost:8080/user-session/show - 查看
*        4. http://localhost:8080/dog-session/show-user - 查看
*
*  测试 - 查看名称相同，但是类型不同
*        1. http://localhost:8080/user-session/create - 创建HttpSession
*        2. http://localhost:8080/user-session/add?name=add&password=add - 创建SessionAttr
*        3. http://localhost:8080/user-session/show - 查看
*        4. http://localhost:8080/user-session/dog
*
*  测试 - 清除的是不是本类的Session
*         1. http://localhost:8080/user-session/create - 创建HttpSession
 *        2. http://localhost:8080/user-session/add?name=add&password=add - 创建SessionAttr-user
 *        3. http://localhost:8080/dog-session/add?name=dog&age=dog - 创建SessionAttr-dog
 *        4. http://localhost:8080/user-session/show - 查看
 *        清除 - http://localhost:8080/user-session/remove
*         查看session - http://localhost:8080/user-session/show
*
*
*
* */
@RestController
@RequestMapping("/user-session")
@SessionAttributes(value = {"user"})
public class UserSessionController {

    // 放入
    @GetMapping("/show")
    public String add(HttpServletRequest request) {
        System.out.println("/usession/show");
        HttpSession session = request.getSession(true);
        System.out.println(session.getId());
        System.out.println(session.getCreationTime());
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            Object value =  session.getAttribute(key);
            System.out.println( key + "---" + value);
        }
        System.out.println("=============================");
        return "查看成功";
    }

   /**
    * 创建Session
    * */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String addSession(HttpSession httpSession) {
        System.out.println("创建Ｓｅｓｓｉｏｎ成功");
        System.out.println("======================");
        return "create-session";
    }

    /**
     * 使用@SessionAttribute添加user到Session中
     * */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public User addSession(User user) {
        System.out.println("/session/add");
        System.out.println("======================");
        return user;
    }

    /**
     * 修改Session
     * */
    @RequestMapping(value = "/change",method = RequestMethod.GET)
    public User changeSession(User user) {
        System.out.println("/session/change");
        System.out.println("======================");
        return user;
    }

    /**
     * 名称相同，类型不同
     * */
    @RequestMapping(value = "/dog",method = RequestMethod.GET)
    public Dog changeSession(Dog user) {
        System.out.println("/session/doog");
        System.out.println(user);
        System.out.println("======================");
        return user;
    }


    /*
     * 清除 -
     * */
    @GetMapping("/remove")
    public String remove(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 清除Session
        return "清除成功";
    }
}
