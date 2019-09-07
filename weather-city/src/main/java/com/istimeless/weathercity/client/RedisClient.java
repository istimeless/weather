package com.istimeless.weathercity.client;

import com.istimeless.weathercommon.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-redis")
public interface RedisClient {

    @PostMapping("redisValue/set")
    Result set(@RequestParam String key, @RequestParam Object value);

    @PostMapping("redisValue/setWithTimeout")
    Result set(@RequestParam String key, @RequestParam Object value, 
             @RequestParam Long timeout, @RequestParam TimeUnit unit);

    @GetMapping("redisValue/get")
    <T> Result<T> get(@RequestParam String key);

    @PostMapping("redisValue/setAll")
    <T> Result<T> set(@RequestBody Map<String, T> map);

    /**
     * 模糊查询key
     * @param key
     * @param <T>
     * @return
     */
    @GetMapping("redisValue/getValues")
    <T> Result<List<T>> getValues(@RequestParam String key);

    @GetMapping("redisValue/getList")
    <T> Result<List<T>> get(@RequestParam Collection<String> keys);
}
