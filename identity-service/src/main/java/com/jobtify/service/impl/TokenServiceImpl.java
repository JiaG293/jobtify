package com.jobtify.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String TOKEN_KEY_PREFIX = "user:token:";

    // Lưu token vào Redis với thời gian hết hạn
    public void cacheToken(String userId, String token, long expirationTime) {
        String key = TOKEN_KEY_PREFIX + userId;
        redisTemplate.opsForValue().set(key, token, expirationTime, TimeUnit.SECONDS);
    }

    // Kiểm tra token có hợp lệ hay không
    public boolean isTokenValid(String userId, String token) {
        String key = TOKEN_KEY_PREFIX + userId;
        String cachedToken = redisTemplate.opsForValue().get(key);

        // Nếu token không tồn tại hoặc không khớp, tức là token invalid
        return cachedToken != null && cachedToken.equals(token);
    }

    // Xóa token khi nó không còn hợp lệ (invalid)
    public void invalidateToken(String userId) {
        String key = TOKEN_KEY_PREFIX + userId;
        redisTemplate.delete(key);
    }
}
