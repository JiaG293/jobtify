package com.api.gateway.repository;

import com.api.gateway.dto.ApiResponse;
import com.api.gateway.dto.request.IntrospectRequest;
import com.api.gateway.dto.response.IntrospectResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@Repository
public interface JobtifySecurityClient {
    @PostExchange(url = "/auth/introspect", contentType = "application/json")
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);

}
