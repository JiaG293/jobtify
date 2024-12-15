package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.ExperienceCreateRequest;
import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.response.ExperienceResponse;
import com.jobtify.dto.response.JobResponse;
import com.jobtify.service.ExperienceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    ExperienceService experienceService;

    @PostMapping
    public ApiResponse<ExperienceResponse> createExperience(@RequestBody ExperienceCreateRequest request) {
        return ApiResponse.<ExperienceResponse>builder()
                .result(experienceService.createExperience(request))
                .build();
    }
    @DeleteMapping("/{experienceId}")
    public ApiResponse<Void> deleteExperience(@PathVariable("experienceId") String experienceId) {
        experienceService.deleteExperience(experienceId);
        return ApiResponse.<Void>builder()
                .build();
    }
}
