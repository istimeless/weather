package com.istimeless.weatherredis.utils;

import com.istimeless.weathercommon.utils.SpringContextHolder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@SuppressWarnings("unchecked")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RedisUtil {
    
    private static final RedisTemplate<String, Object> REDIS_TEMPLATE = 
            SpringContextHolder.getBean("redisTemplate", RedisTemplate.class);
    
    public static <T> void set(String key, T value){
        REDIS_TEMPLATE.opsForValue().set(key, value);
    }

    public static <T> void set(String key, T value, Long timeout, TimeUnit timeUnit){
        REDIS_TEMPLATE.opsForValue().set(key, value, timeout, timeUnit);
    }

    public static <T> void set(Map<String, T> map){
        REDIS_TEMPLATE.opsForValue().multiSet(map);
    }

    public static <T> T get(String key){
        return (T) REDIS_TEMPLATE.opsForValue().get(key);
    }

    public static <T> List<T> get(Collection<String> keys){
        return (List<T>) REDIS_TEMPLATE.opsForValue().multiGet(keys);
    }

    /**
     * 模糊查询key
     * @param key
     * @param <T>
     * @return
     */
    public static <T> List<T> getLikes(String key){
        Set<String> keys = REDIS_TEMPLATE.keys("*" + key + "*");
        return get(keys);
    }
}
