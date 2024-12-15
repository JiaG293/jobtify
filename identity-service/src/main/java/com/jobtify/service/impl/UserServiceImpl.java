package com.jobtify.service.impl;

import com.jobtify.dto.request.UserCheckRequest;
import com.jobtify.dto.request.UserCreateRequest;
import com.jobtify.dto.request.UserUpdateRequest;
import com.jobtify.dto.response.UserCheckResponse;
import com.jobtify.dto.response.UserResponse;
import com.jobtify.dto.response.UserVerifyEmailResponse;
import com.jobtify.event.enums.TypeRegisterAccount;
import com.jobtify.event.mapper.CreateUserEventMapper;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.entity.Role;
import com.jobtify.model.entity.User;
import com.jobtify.model.enums.PredefinedRole;
import com.jobtify.model.mapper.UserMapper;
import com.jobtify.repository.RoleRepository;
import com.jobtify.repository.UserRepository;
import com.jobtify.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    CreateUserEventMapper createUserEventMapper;
    KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public UserCheckResponse checkFieldUser(UserCheckRequest request) {
        Map<String, Function<String, Boolean>> checkFunctions = Map.of(
                "EMAIL", userRepository::existsByEmail,
                "PHONE", userRepository::existsByPhone,
                "USERNAME", userRepository::existsByUsername
        );

        Function<String, Boolean> checkFunction = checkFunctions.get(request.getType().toUpperCase());

        return UserCheckResponse.builder()
                .type(request.getType())
                .isExisted(checkFunction.apply(request.getValue()))
                .build();
    }

    @Override
    public UserVerifyEmailResponse verifyEmail(String email) {
        return null;
    }

    @Override
    public UserResponse registerUser(UserCreateRequest request) {
        log.info("user la {}", request);
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        if (TypeRegisterAccount.CANDIDATE.equals(request.getType())) {
            roleRepository.findByName(PredefinedRole.USER_CANDIDATE.getRoleName()).ifPresent(roles::add);
        } else if (TypeRegisterAccount.COMPANY.equals(request.getType())) {
            roleRepository.findByName(PredefinedRole.USER_COMPANY.getRoleName()).ifPresent(roles::add);
        } else {
            throw new AppException(ErrorCode.ROLE_INVALID);
        }

        user.setRoles(roles);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        //gui event create profile candidate || company
        kafkaTemplate.send("user-create-topic",
                createUserEventMapper.toCreateUserEvent(request, user.getId()));

        return userMapper.toUserResponse(user);
    }


    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @PostAuthorize("returnObject.username== authentication.name")
    @Override
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var roles = roleRepository.findAllById(Collections.singleton(userId));
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }


    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public List<UserResponse> getUsers() {
        log.info("In method get Users");
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
}
