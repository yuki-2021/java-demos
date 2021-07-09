package com.yuki.web.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册Filter
 *
 * 四种方式
 * 1. 使用@Component配合Filter
 * 2. 使用FilterRegistrationBean、ServletRegistrationBean
 * 3. 使用ServletContextInitializer注册
 * 4. 使用@ServletComponentScan配合@WebFilter、@WebServlet、@WebListener
 * */
@RestController
public class FilterController {

    @GetMapping("/simple")
    public String simple() {
        return "simple";
    }
}
