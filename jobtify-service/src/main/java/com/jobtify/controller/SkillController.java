package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.request.SkillCreateRequest;
import com.jobtify.dto.request.SkillUpdateRequest;
import com.jobtify.dto.response.SkillResponse;
import com.jobtify.service.SkillService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/skills")
public class SkillController {
    SkillService skillService;

    @GetMapping
    public ApiResponse<Page<SkillResponse>> getListSkillPage(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "s", defaultValue = "10") int size,
            @RequestParam(value = "sb", defaultValue = "id") String sortBy,
            @RequestParam(value = "sd", defaultValue = "asc") String sortDirection) {
        return ApiResponse.<Page<SkillResponse>>builder()
                .result(skillService.findAll(page, size, sortBy, sortDirection))
                .build();
    }

    @PostMapping
    public ApiResponse<SkillResponse> createSkillBase(@RequestBody SkillCreateRequest request) {
        return ApiResponse.<SkillResponse>builder()
                .result(skillService.createSkillBase(request))
                .build();
    }

    @PatchMapping("/{skillId}")
    public ApiResponse<SkillResponse> updateSkillBase(@PathVariable String skillId, @Valid @RequestBody SkillUpdateRequest request) {
        return ApiResponse.<SkillResponse>builder()
                .result(skillService.updateSkill(skillId, request))
                .build();
    }

    @DeleteMapping("/{skillId}")
    public ApiResponse<Void> deleteSkillBase(@PathVariable String skillId) {
        skillService.deleteSkill(skillId);
        return ApiResponse.<Void>builder()
                .build();
    }

}
