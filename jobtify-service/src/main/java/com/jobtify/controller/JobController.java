package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.request.JobUpdateRequest;
import com.jobtify.dto.response.JobDetailResponse;
import com.jobtify.dto.response.JobResponse;
import com.jobtify.model.entity.Job;
import com.jobtify.service.JobService;
import com.jobtify.service.JobSkillService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/jobs")
public class JobController {
    JobService jobService;
    JobSkillService jobSkillService;

    @GetMapping
    public ApiResponse<Page<JobDetailResponse>> getListJob(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "s", defaultValue = "10") int size,
            @RequestParam(value = "sb", defaultValue = "id") String sortBy,
            @RequestParam(value = "sd", defaultValue = "asc") String sortDirection
    ) {
        return ApiResponse.<Page<JobDetailResponse>>builder()
                .result(jobService.findAll(page, size, sortBy, sortDirection))
                .build();
    }


    @PostMapping
    public ApiResponse<JobResponse> createJob(@RequestBody JobCreateRequest request) {
        return ApiResponse.<JobResponse>builder()
                .result(jobService.createJob(request))
                .build();
    }


    @PatchMapping("/{jobId}")
    public ApiResponse<JobResponse> updateJob(@PathVariable("jobId") String jobId, @RequestBody JobUpdateRequest request) {
        return ApiResponse.<JobResponse>builder()
                .result(jobService.updateJob(jobId, request))
                .build();
    }
}
