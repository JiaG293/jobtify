package com.jobtify.service;

import com.jobtify.dto.request.UserCheckRequest;
import com.jobtify.dto.request.UserCreateRequest;
import com.jobtify.dto.response.UserCheckResponse;
import com.jobtify.dto.response.UserResponse;
import com.jobtify.dto.response.UserVerifyEmailResponse;


public interface UserRegisterService{
    UserCheckResponse checkFieldUser(UserCheckRequest request);
    UserVerifyEmailResponse verifyEmail(String email);
    UserResponse registerUser(UserCreateRequest request);
}
