package com.jobtify.service;


import com.jobtify.event.dto.CreateUserEvent;

public interface ProfileService {
    void createProfileEvent(CreateUserEvent event);
}
