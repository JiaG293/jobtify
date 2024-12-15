package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.CandidateSkillCreateRequest;
import com.jobtify.dto.request.CandidateSkillUpdateRequest;
import com.jobtify.dto.response.CandidateSkilListResponse;
import com.jobtify.dto.response.CandidateSkillResponse;
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
@RequestMapping("/companies")
public class CompanyController {
   /* @GetMapping
    public ApiResponse<> getListSkill() {
        return ApiResponse.<>builder()
                .build();
    }*/

   /* @PostMapping("/skills")
    public ApiResponse<> createMySkill(@RequestBody CandidateSkillCreateRequest request) {
        return ApiResponse.<CandidateSkillResponse>builder()
                .build();
    }

    @PatchMapping("/skills")
    public ApiResponse<CandidateSkillResponse> updateMySkill(@RequestBody CandidateSkillUpdateRequest request) {
        return ApiResponse.<CandidateSkillResponse>builder()
                .result(candidateSkillService.updateCandidateSkill(request))
                .build();
    }*/
}
