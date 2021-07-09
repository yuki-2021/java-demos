package com.yuki.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
* 方式1  - FilerRegistrationBean注册Filter
* */
@Configuration
public class FilterRegistrationBeanConfig {

    @Bean
    public FilterRegistrationBean helloWroldFilter() {
        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new HelloWorldFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setName("helloWorldFilter");
        filterRegistration.setOrder(1);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean pathFilter() {
        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new PathFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setName("pathFilter");
        filterRegistration.setOrder(1);
        return filterRegistration;
    }
}
