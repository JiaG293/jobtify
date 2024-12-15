package com.jobtify.controller;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.repository.AddressRepository;
import com.jobtify.service.ProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/profile")
public class ProfileController {
    ProfileService profileService;
    AddressRepository addressRepository;

    @KafkaListener(topics = "user-create-topic")
    public void createProfileEvent(CreateUserEvent event){
        profileService.createProfileEvent(event);
    }
    @GetMapping("/1")
    public void test1(){
        System.out.println(addressRepository.findAll());

    }

}
