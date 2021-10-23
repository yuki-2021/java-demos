package com.yuki.mvc.param.cookie_old;


import com.yuki.mvc.entity.Dog;
import com.yuki.mvc.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @SessionAttributes
 * */
@RequestMapping("/dog-session")
@SessionAttributes(value = {"user","dog"})
public class DogSessionController {

    /**
     * 查看User
     */
    @GetMapping("/show-user")
    public User add(User user) {
        System.out.println("在dog中查看Session-User");
        System.out.println(user);
        System.out.println("=============================");
        return user;
    }

    /**
     * @SessionAttributes - 把User放到Session中
     * */
    @GetMapping("/add")
    public Dog add(Dog dog) {
        System.out.println("/dog/add");
        System.out.println(dog);
        System.out.println("=============================");
        return dog;
    }
}
