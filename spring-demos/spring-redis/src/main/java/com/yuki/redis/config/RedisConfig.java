package com.yuki.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis配置文件
 * */
@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * JedisPoolConfig - JedisPool的配置
     * */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        // 1. 创建JedisPoolConfig
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxWaitMillis(10);
        poolConfig.setTestOnBorrow(false);
        // 2. 返回
        return poolConfig;
    }

    /**
     * 配置JedisConnectionFactory - Jedis连接工厂
     * */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        // 1. 创建RedisConfig
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName("10.0.0.200");
        redisConfig.setPort(6379);
        redisConfig.setPassword("123456");
        redisConfig.setDatabase(0);
        // 2. 创建Jedisfiguration
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisConfigBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        JedisClientConfiguration jedisConfig = jedisConfigBuilder.poolConfig(poolConfig).build();
        // 3. 创建ConnectionFactory
        return new JedisConnectionFactory(redisConfig, jedisConfig);
    }

    /**
     * 配置 RedisCacheManager - SpringCache使用CacheManager来操作缓存
     * */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connFactory) {
        // 1. 创建CacheWriter,CacheManager使用它来操作Redis
        RedisCacheWriter cacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connFactory);
        // 2. 创建RedisCacheConfiguration,这里主要定义SpringCache如何去Serializer、DeSerializer、keyPrefix(如何根据cacheName生成缓存key前置)
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        // 3. 返回RedisCacheManager
        return new RedisCacheManager(cacheWriter,cacheConfiguration);
    }



    /**
     * RedisTemplate - 配置RedisTemplate
     * */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 1. 创建RedisTemplate
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 2. 返回redisTemplate
        return redisTemplate;
    }

}
