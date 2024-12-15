package com.api.gateway.config;

import com.api.gateway.dto.ApiResponse;
import com.api.gateway.service.JobtifySecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {
    JobtifySecurityService jobtifySecurityService;
    ObjectMapper jacksonObjectMapper;


    @NonFinal
    protected String[] publicEnpoints = {
            "/identity/auth/login",
            "/identity/auth/introspect",
            "/identity/auth/logout",
            "/identity/auth/refresh",
            "/identity/users/register",
            "/identity/users/check",
            "/identity/users/test",
            "/jobtify/jobs"
    };
    @NonFinal
    @Value("${app.api-prefix}")
    protected String apiPrefix;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("API GATEWAY FILTER CHAIN... ");

        if (isPublicEnpoint(exchange.getRequest())) {
            return chain.filter(exchange);
        }

        //Truy xuat header lay ra authorization-token tu request
        List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
        log.info("token: {}", authHeader);

        if (CollectionUtils.isEmpty(authHeader)) {
            return unauthenticated(exchange.getResponse());
        }
        String token = authHeader.getFirst().replace("Bearer", "");

        //Xac thuc token thong qua jobtify security
        jobtifySecurityService.introspect(token)
                .flatMap(introspectResponseApiResponse -> {
                    if (introspectResponseApiResponse.getResult().isValid()) {
                        return chain.filter(exchange);
                    } else {
                        return unauthenticated(exchange.getResponse());
                    }
                }).onErrorResume(throwable -> unauthenticated(exchange.getResponse()));

        //Chuyen huong den service
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    private boolean isPublicEnpoint(ServerHttpRequest request) {
        return Arrays.stream(publicEnpoints)
                .anyMatch(ep -> request.getURI().getPath().matches(apiPrefix + ep));
    }


    private Mono<Void> unauthenticated(ServerHttpResponse response) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(1112)
                .message("unauthenticated")
                .build();
        String body = null;
        try {
            body = jacksonObjectMapper.writeValueAsString(apiResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json");
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(body.getBytes())));
    }

}
