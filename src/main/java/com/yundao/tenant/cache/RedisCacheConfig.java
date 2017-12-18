package com.yundao.tenant.cache;

/**
 * @author jan
 * @create 2017-08-25 PM11:25
 **/

import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@AutoConfigureOrder
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    private static Log log = LogFactory.getLog(RedisCacheConfig.class);

    /**
     * 缓存管理器.
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }


    /**
     * RedisTemplate缓存操作类,类似于jdbcTemplate的一个类;
     * <p>
     * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
     * <p>
     * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
     * <p>
     * 自己的缓存类，比如：RedisStorage类;
     *
     * @param factory : 通过Spring进行注入，参数在application.properties进行配置；
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        log.info("redis注入开始");
        JedisConnectionFactory jcf = (JedisConnectionFactory) factory;
        log.info("redis注入配置信息 host:%s", jcf.getHostName());
        log.info("redis注入配置信息 pwd:%s", jcf.getPassword());
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);

        return redisTemplate;
    }

    /**
     * 自定义key.
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName());
            sb.append("[");
            sb.append(method.getName() + "(");
            int index = 1;
            for (Object obj : objects) {
                sb.append(obj.toString());
                if (index != objects.length)
                    sb.append(",");
            }
            sb.append(")]");
            log.info("keyGenerator=" + sb.toString());
            return sb.toString();
        };
    }

}