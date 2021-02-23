package com.yuki.demo2a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/*
* 引入 ConfigInnter
* */
@Configuration
@Import({ConfigInner.class})
@ImportResource({"classpath:inner.xml"})
public class ConfigOutter {

}
