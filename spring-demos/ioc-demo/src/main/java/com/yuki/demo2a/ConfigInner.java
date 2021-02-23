package com.yuki.demo2a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigInner {

    @Bean
    public Dog dog1() {
        return new Dog("哮天犬",11,"无限连击");
    }
}
