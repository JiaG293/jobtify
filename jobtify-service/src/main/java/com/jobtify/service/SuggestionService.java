package com.jobtify.service;

import com.jobtify.dto.response.JobDetailResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SuggestionService {
    Page<JobDetailResponse> findJobRelated(int page, int size, String sortBy, String sortDirection);
}
