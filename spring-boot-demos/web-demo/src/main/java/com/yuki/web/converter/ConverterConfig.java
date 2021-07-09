package com.yuki.web.converter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.nio.charset.StandardCharsets;

/**
*  配置Converters
 *  1. 要没直接使用HttpMessageConverter
 *  2. 要没使用HttpMessageConverters
* */
@Configuration
public class ConverterConfig {

    /**
     * 配置FastJsonHttpMessageConverter
     * */
    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverter(){
        // 1. fastJsonHttpMessageConverter
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        // 2. 构建配置
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //    输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                //    数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect
        };
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);

        // 3. 注册到HttpMessageConverter
        return fastJsonConverter;
    }


    /**
    *  配置HttpMessageConverters
    * */
    @Bean
    public HttpMessageConverters xmlHttpMessageConverter() {
        // 1. xml converter
        MappingJackson2XmlHttpMessageConverter xmlConverter
                = new MappingJackson2XmlHttpMessageConverter();

        // 2. 返回Converters
        return new HttpMessageConverters(xmlConverter);
    }
}
