package com.api.gateway.service;

import com.api.gateway.dto.ApiResponse;
import com.api.gateway.dto.request.IntrospectRequest;
import com.api.gateway.dto.response.IntrospectResponse;
import com.api.gateway.repository.JobtifySecurityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class JobtifySecurityService {
    JobtifySecurityClient jobtifySecurityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return jobtifySecurityClient.introspect(
                IntrospectRequest.builder()
                        .token(token)
                        .build());
    }
}
