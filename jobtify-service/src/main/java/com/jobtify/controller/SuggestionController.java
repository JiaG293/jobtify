package com.jobtify.controller;

import com.jobtify.dto.ApiResponse;
import com.jobtify.dto.response.JobDetailResponse;
import com.jobtify.service.SuggestionService;
import com.jobtify.service.impl.SuggestionServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/jobs/suggest")
public class SuggestionController {
    SuggestionService suggestionService;

    @GetMapping
    public ApiResponse<Page<JobDetailResponse>> getSuggestions(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "s", defaultValue = "10") int size,
            @RequestParam(value = "sb", defaultValue = "id") String sortBy,
            @RequestParam(value = "sd", defaultValue = "asc") String sortDirection
    ) {
        return ApiResponse.<Page<JobDetailResponse>>builder()
                .result(suggestionService.findJobRelated(page, size, sortBy, sortDirection))
                .build();
    }
}
