package com.yuki.boot.first;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class FirstApplication {

    @GetMapping("/")
    public String home()  {
        return "hello-woraald";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(FirstApplication.class, args);
    }
}
