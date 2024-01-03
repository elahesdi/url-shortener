package com.ela.springbootredis.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;



@Configuration
@ComponentScan("com.ela.springbootredis")
@EnableRedisRepositories(basePackages = "com.ela.springbootredis")
@PropertySource("classpath:application.properties")
public class RedisConfig {

  @Value("${redis.duration}")
  private int duration;
  @Value("${redis.host}")
  private String redisHost;
  RedisStandaloneConfiguration standaloneConfiguration() {
    return new RedisStandaloneConfiguration(redisHost, 6379);
  }
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory(standaloneConfiguration());
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    JedisConnectionFactory jedisConnectionFactory = jedisConnectionFactory();
    template.setConnectionFactory(jedisConnectionFactory);
    template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
    return template;
  }

  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
    return (builder) -> builder
        .withCacheConfiguration("urlCache",
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(duration)));
  }

}
