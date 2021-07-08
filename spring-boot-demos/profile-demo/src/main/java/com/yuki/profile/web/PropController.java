package com.yuki.profile.web;

import com.yuki.profile.config.Prop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class PropController {

    @Autowired
    private Prop prop;

    @GetMapping("/prop")
    public Prop user() {
        return prop;
    }
}
