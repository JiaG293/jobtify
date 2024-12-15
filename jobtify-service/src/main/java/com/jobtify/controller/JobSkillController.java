package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.JobSkillUpdateRequest;
import com.jobtify.dto.response.JobResponse;
import com.jobtify.dto.response.JobSkillListResponse;
import com.jobtify.dto.response.JobSkillResponse;
import com.jobtify.dto.response.SkillResponse;
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
public class JobSkillController {
    JobService jobService;
    JobSkillService jobSkillService;

    @PutMapping("/{jobId}/skills/{skillId}")
    public ApiResponse<JobSkillResponse> updateJobSkill(
            @PathVariable("jobId") String jobId,
            @PathVariable("skillId") String skillId,
            @RequestBody JobSkillUpdateRequest request
    ) {
        return ApiResponse.<JobSkillResponse>builder()
                .result(jobSkillService.updateJobSkill(jobId, skillId, request))
                .build();
    }

    @GetMapping("/job-skills")
    public ApiResponse<Page<JobSkillListResponse>> getPageJobSkill(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "s", defaultValue = "10") int size,
            @RequestParam(value = "sb", defaultValue = "updatedAt") String sortBy,
            @RequestParam(value = "sd", defaultValue = "asc") String sortDirection
    ) {
        return ApiResponse.<Page<JobSkillListResponse>>builder()
                .result(jobSkillService.findAllPageJobSkill(page, size, sortBy, sortDirection))
                .build();
    }



    @DeleteMapping("/jobs/{jobId}/skills/{skillId}")
    public ApiResponse<Void> getListJob(
            @PathVariable("jobId") String jobId,
            @PathVariable("skillId") String skillId
    ) {
        jobSkillService.deleteJobSkill(jobId, skillId);

        return ApiResponse.<Void>builder().build();
    }
}
