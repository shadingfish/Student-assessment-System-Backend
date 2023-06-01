package com.babybus.stu.eval.yudingyi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValueWithExpiration(String key, String value, long expirationSeconds) {
        redisTemplate.opsForValue().set(key, value, expirationSeconds, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

    public boolean isValidToken(String token) {
        return redisTemplate.hasKey(token);
    }

    public Long rpush(String key, String... values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    public List<String> getListValues(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public List<String> lrange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    public Long llen(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public void lrem(String key, long count, String value) {
        redisTemplate.opsForList().remove(key, count, value);
    }
}
