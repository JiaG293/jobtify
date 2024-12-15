package com.jobtify.service;

import com.jobtify.dto.request.ExperienceCreateRequest;
import com.jobtify.dto.request.ExperienceUpdateRequest;
import com.jobtify.dto.response.ExperienceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExperienceService {
    ExperienceResponse createExperience(ExperienceCreateRequest request);
    void deleteExperience(String experienceId);
    ExperienceResponse updateExperience(String skillId, ExperienceUpdateRequest request);
    Page<ExperienceResponse> findAll(int page, int limit, String sortBy, String sortDirection);
    Page<ExperienceResponse> findPaginated(Pageable pageable);
}
