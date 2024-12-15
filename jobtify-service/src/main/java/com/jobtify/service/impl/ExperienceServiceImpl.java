package com.jobtify.service.impl;

import com.jobtify.dto.request.ExperienceCreateRequest;
import com.jobtify.dto.request.ExperienceUpdateRequest;
import com.jobtify.dto.response.ExperienceResponse;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.mapper.ExperienceMapper;
import com.jobtify.repository.ExperienceRepository;
import com.jobtify.service.ExperienceService;
import com.jobtify.config.ClaimsExtractor;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ExperienceServiceImpl implements ExperienceService {
    ExperienceMapper experienceMapper;
    ExperienceRepository experienceRepository;
    ClaimsExtractor claimsExtractor;

    @Override
    @PreAuthorize("hasRole('USER_CANDIDATE')")
    public ExperienceResponse createExperience(ExperienceCreateRequest request) {
        var experience = experienceMapper.toExperience(request);
        experience = experienceRepository.save(experience);
        return experienceMapper.toExperienceResponse(experience);
    }

    @Override
    public void deleteExperience(String experienceId) {
        var experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new AppException(ErrorCode.EXPERIENCE_NOT_EXISTED));
        experienceRepository.delete(experience);
    }

    @Override
    @PreAuthorize("hasRole('USER_CANDIDATE')")
    public ExperienceResponse updateExperience(String experienceId, ExperienceUpdateRequest request) {
        var experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new AppException(ErrorCode.EXPERIENCE_NOT_EXISTED));
        experienceMapper.updateRequestToExperience(request, experience);
        return experienceMapper.toExperienceResponse(experienceRepository.save(experience));
    }

    @Override
    public Page<ExperienceResponse> findAll(int page, int size, String sortBy, String sortDirection) {
        String defaultSortDirection = sortDirection.equalsIgnoreCase("asc") ? sortDirection : "desc";

        Sort sort = Sort.by(Sort.Direction.fromString(defaultSortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return experienceRepository.findAll(pageable).map(experienceMapper::toExperienceResponse);
    }

    @Override
    public Page<ExperienceResponse> findPaginated(Pageable pageable) {
        return null;
    }
}
