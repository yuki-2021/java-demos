package com.yuki.app;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {


    // ExitCodeGenerator - 执行完毕
    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

    //
    public static void main(String[] args) {
        int code = SpringApplication.exit(SpringApplication.run(AppApplication.class, args));
        System.out.println(code);

    }

}
