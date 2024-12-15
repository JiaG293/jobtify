package com.jobtify.controller;

import com.jobtify.dto.base.ApiResponse;
import com.jobtify.dto.request.UserCheckRequest;
import com.jobtify.dto.request.UserCreateRequest;
import com.jobtify.dto.request.UserUpdateRequest;
import com.jobtify.dto.response.UserCheckResponse;
import com.jobtify.dto.response.UserResponse;
import com.jobtify.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;


    @PostMapping("/test")
    ApiResponse<String> test() {
        var result = "WELCOME TO THE HELL";
        return ApiResponse.<String>builder().result(result).build();
    }

    @PostMapping("/check")
    ApiResponse<UserCheckResponse> checkField(@RequestBody UserCheckRequest request) {
        var result = userService.checkFieldUser(request);
        return ApiResponse.<UserCheckResponse>builder().result(result).build();
    }

    @PostMapping("/register")
    ApiResponse<UserResponse> registerUser(@RequestBody UserCreateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.registerUser(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/my-info")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }
}
