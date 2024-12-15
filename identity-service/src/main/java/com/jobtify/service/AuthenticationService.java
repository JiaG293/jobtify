package com.jobtify.service;

import com.jobtify.dto.request.AuthenticationRequest;
import com.jobtify.dto.request.IntrospectRequest;
import com.jobtify.dto.request.LogoutRequest;
import com.jobtify.dto.request.RefreshRequest;
import com.jobtify.dto.response.AuthenticationResponse;
import com.jobtify.dto.response.IntrospectResponse;

public interface AuthenticationService {
    IntrospectResponse introspect(IntrospectRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void logout(LogoutRequest request);

    AuthenticationResponse refreshToken(RefreshRequest request);
}
