package com.jobtify.service;

import java.util.Date;

public interface InvalidatedTokenRedisService {
    boolean isTokenInvalidated(String jwtId);
    void cacheToken(String jwtId, Date expiryTime);
    void removeToken(String jwtId);
}
