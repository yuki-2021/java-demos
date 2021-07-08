package com.yuki.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfileApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProfileApplication.class);
        springApplication.setAdditionalProfiles("mysql-dev","redis-dev");
        springApplication.run();
    }

}
