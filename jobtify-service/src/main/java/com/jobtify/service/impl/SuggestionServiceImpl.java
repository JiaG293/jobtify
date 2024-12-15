package com.jobtify.service.impl;

import com.jobtify.config.ClaimsExtractor;
import com.jobtify.dto.response.JobDetailResponse;
import com.jobtify.model.entity.Job;
import com.jobtify.model.mapper.JobMapper;
import com.jobtify.repository.JobRepository;
import com.jobtify.repository.JobSkillRepository;
import com.jobtify.service.SuggestionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class SuggestionServiceImpl implements SuggestionService {
    JobRepository jobRepository;
    ClaimsExtractor claimsExtractor;
    JobMapper jobMapper;

    @Override
    @PreAuthorize("hasRole('USER_CANDIDATE')")
    public Page<JobDetailResponse> findJobRelated(int page, int size, String sortBy, String sortDirection) {
        String defaultSortDirection = sortDirection.equalsIgnoreCase("asc") ? sortDirection : "desc";
        Sort sort = Sort.by(Sort.Direction.fromString(defaultSortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        List<String> jobIds = jobRepository.findMatchingJobs(claimsExtractor.getClaim("uid").toString());

        int fromIndex = (int) pageable.getOffset();
        int toIndex = Math.min(fromIndex + size, jobIds.size());

        if (fromIndex >= jobIds.size()) {
            return new PageImpl<>(Collections.emptyList(), pageable, jobIds.size());
        }

        List<String> paginatedJobIds = jobIds.subList(fromIndex, toIndex);

        List<Job> jobs = jobRepository.findByIdIn(paginatedJobIds);

        List<JobDetailResponse> responses = jobs.stream()
                .map(job -> jobMapper.toJobDetailResponse(job))
                .collect(Collectors.toList());

        return new PageImpl<>(responses, pageable, jobIds.size());
    }
}
