package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.CandidateSkillCreateRequest;
import com.jobtify.dto.request.CandidateSkillUpdateRequest;
import com.jobtify.dto.response.CandidateSkilListResponse;
import com.jobtify.dto.response.CandidateSkillResponse;
import com.jobtify.service.CandidateSkillService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/candidates")
public class CandidateController {
    CandidateSkillService candidateSkillService;


    @GetMapping
    public ApiResponse<List<CandidateSkilListResponse>> getListSkill() {
        return ApiResponse.<List<CandidateSkilListResponse>>builder()
                .result(candidateSkillService.findAllMyCandidateSkill())
                .build();
    }

    @PostMapping("/skills")
    public ApiResponse<CandidateSkillResponse> createMySkill(@RequestBody CandidateSkillCreateRequest request) {
        return ApiResponse.<CandidateSkillResponse>builder()
                .result(candidateSkillService.createCandidateSkill(request))
                .build();
    }

    @PatchMapping("/skills")
    public ApiResponse<CandidateSkillResponse> updateMySkill(@RequestBody CandidateSkillUpdateRequest request) {
        return ApiResponse.<CandidateSkillResponse>builder()
                .result(candidateSkillService.updateCandidateSkill(request))
                .build();
    }
}
