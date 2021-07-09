package com.yuki.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
* 集成Themeleaf
* */
@Controller
public class ThymeleafController {

    @GetMapping("thymelaf")
    public String index(Model model) {
        model.addAttribute("msg","this is thymeleaf");
        return "thymeleaf";
    }
}
