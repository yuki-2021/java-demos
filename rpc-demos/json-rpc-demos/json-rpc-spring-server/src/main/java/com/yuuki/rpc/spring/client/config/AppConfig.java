package com.yuuki.rpc.spring.client.config;

import com.yuuki.rpc.spring.client.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

   /**
   * RootConfig
   * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    /**
     * WebConfig
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    /**
     * Dispatcher的路径
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/*"};
    }
}
