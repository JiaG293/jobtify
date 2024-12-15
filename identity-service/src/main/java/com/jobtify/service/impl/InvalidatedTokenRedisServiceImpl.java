/*
package com.jobtify.service.impl;

import com.jobtify.service.InvalidatedTokenRedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class InvalidatedTokenRedisServiceImpl implements InvalidatedTokenRedisService {

    @NonFinal
    protected String TOKEN_KEY_PREFIX = "invalidated_token:";

    @NonFinal
    @Value("${spring.data.redis.ttl}")
    protected long TTL;

    RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean isTokenInvalidated(String jwtId) {
        return redisTemplate.hasKey(TOKEN_KEY_PREFIX + jwtId);
    }

    @Override
    public void cacheToken(String jwtId, Date expiryTime) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        long ttlMillis = expiryTime.getTime() - System.currentTimeMillis();

        // Sử dụng TTL động hoặc mặc định (tính theo ngày)
        if (ttlMillis > 0) {
            long ttlSeconds = Math.min(ttlMillis, TTL) / 1000;
            valueOps.set(TOKEN_KEY_PREFIX + jwtId, "invalid", ttlSeconds, TimeUnit.SECONDS);
        } else {
            log.warn("Token expiry time is in the past: {}", expiryTime);
        }
    }

    @Override
    public void removeToken(String tokenId) {
        redisTemplate.delete(TOKEN_KEY_PREFIX + tokenId);
    }
}
*/
