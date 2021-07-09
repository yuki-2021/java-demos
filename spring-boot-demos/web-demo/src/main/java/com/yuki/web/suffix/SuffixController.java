package com.yuki.web.suffix;

import com.yuki.web.entity.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 路径匹配、内容协商
* */
@RestController
@RequestMapping("/suffix")
public class SuffixController {

    @GetMapping
    public Dog dog() {
        return new Dog("dog1","11");
    }
}
