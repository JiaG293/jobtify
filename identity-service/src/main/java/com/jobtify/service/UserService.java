package com.jobtify.service;

import com.jobtify.dto.request.UserUpdateRequest;
import com.jobtify.dto.response.UserResponse;

import java.util.List;


public interface UserService extends UserRegisterService{
    UserResponse getMyInfo();
    UserResponse updateUser(String userId, UserUpdateRequest request);
    void deleteUser(String userId);
    List<UserResponse> getUsers();
    UserResponse getUser(String id);
}
