package com.yuki.profile.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "prop")
@Component
public class Prop {

    private String redis;
    private String mysql;
}
