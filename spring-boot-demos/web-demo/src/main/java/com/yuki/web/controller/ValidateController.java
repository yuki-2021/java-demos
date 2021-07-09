package com.yuki.web.controller;

import com.yuki.web.entity.Dog;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
public class ValidateController {

    @GetMapping
    public Dog dog(@Validated Dog dog, BindingResult result) {
        // 1. 输出错误
        if(result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getCode());
                System.out.println(fieldError.getDefaultMessage());
                System.out.println("------");
                for (String code : fieldError.getCodes()) {
                    System.out.println(code);
                }
                System.out.println("==================================");
            }
        }

        return dog;
    }
}
