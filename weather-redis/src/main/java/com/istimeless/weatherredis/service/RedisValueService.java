package com.istimeless.weatherredis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@Service
@SuppressWarnings("all")
public class RedisValueService {
    
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisValueService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, Long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }
    
    public <T> void set(Map<String, T> map){
        redisTemplate.opsForValue().multiSet(map);
    }
    
    public <T> T get(String key){
        return (T) redisTemplate.opsForValue().get(key);
    }
    
    public <T> List<T> get(Collection<String> keys){
        return (List<T>) redisTemplate.opsForValue().multiGet(keys);
    }

    public <T> List<T> getValues(String key){
        Set<String> keys = redisTemplate.keys("*" + key + "*");
        return get(keys);
    }
}
