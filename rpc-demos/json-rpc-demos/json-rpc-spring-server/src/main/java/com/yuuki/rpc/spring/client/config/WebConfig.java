package com.yuuki.rpc.spring.client.config;

import com.yuuki.rpc.spring.client.config.rpc.RpcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  WebApplication的配置
 * */
@EnableWebMvc
@Configuration
@Import(value = { RpcConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
}
