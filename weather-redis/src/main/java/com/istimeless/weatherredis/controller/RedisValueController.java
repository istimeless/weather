package com.istimeless.weatherredis.controller;

import com.istimeless.weatherredis.service.RedisValueService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@RestController
public class RedisValueController {
    
    private final RedisValueService redisValueService;


    public RedisValueController(RedisValueService redisValueService) {
        this.redisValueService = redisValueService;
    }

    /**
     * 设置value
     * @param key
     * @param value
     */
    @PostMapping("redisValue/set")
    public void set(@RequestParam String key, @RequestParam Object value){
        redisValueService.set(key, value);
    }

    /**
     * 设置value和超时时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    @PostMapping("redisValue/setWithTimeout")
    public void set(@RequestParam String key,
                    @RequestParam Object value,
                    @RequestParam Long timeout,
                    @RequestParam TimeUnit unit){
        redisValueService.set(key, value, timeout, unit);
    }

    /**
     * 精确获取单个值
     * @param key
     * @param <T>
     * @return
     */
    @GetMapping("redisValue/get")
    public <T> T get(@RequestParam String key){
        return redisValueService.get(key);
    }

    /**
     * 传入多个key获取多个value
     * @param keys
     * @param <T>
     * @return
     */
    @GetMapping("redisValue/getList")
    public <T> List<T> get(@RequestParam Collection<String> keys){
        return redisValueService.get(keys);
    }

    /**
     * 设置多个值
     * @param map
     * @param <T>
     */
    @PostMapping("redisValue/setAll")
    public <T> void set(@RequestBody Map<String, T> map) {
        redisValueService.set(map);
    }

    /**
     * 模糊查询key的value
     * @param key
     * @param <T>
     * @return
     */
    @GetMapping("redisValue/getValues")
    public <T> List<T> getValues(@RequestParam String key){
        return redisValueService.getValues(key);
    }
}
