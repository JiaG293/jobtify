package com.jobtify.service.impl;

import com.jobtify.dto.request.JobSkillCreateRequest;
import com.jobtify.dto.request.JobSkillUpdateRequest;
import com.jobtify.dto.response.JobSkillListResponse;
import com.jobtify.dto.response.JobSkillResponse;
import com.jobtify.dto.response.SkillResponse;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.entity.Job;
import com.jobtify.model.entity.JobSkill;
import com.jobtify.model.enums.SkillLevel;
import com.jobtify.model.ids.JobSkillId;
import com.jobtify.model.mapper.JobSkillMapper;
import com.jobtify.repository.JobRepository;
import com.jobtify.repository.JobSkillRepository;
import com.jobtify.repository.SkillRepository;
import com.jobtify.service.JobSkillService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class JobSkillServiceImpl implements JobSkillService {
    SkillRepository skillRepository;
    JobRepository jobRepository;
    JobSkillRepository jobSkillRepository;
    JobSkillMapper jobSkillMapper;

    @Override
    public JobSkillResponse getJobSkillResponse(String jobSkillId) {
        return null;
    }

    @Override
    public List<JobSkillListResponse> findAllJobSkill() {

        return List.of();
    }

    @Override
    public Page<JobSkillListResponse> findAllPageJobSkill(int page, int size, String sortBy, String sortDirection) {
        String defaultSortDirection = sortDirection.equalsIgnoreCase("asc") ? sortDirection : "desc";

        Sort sort = Sort.by(Sort.Direction.fromString(defaultSortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<JobSkill> jobSkillPage = jobSkillRepository.fetchJobSkills(pageable);

        Map<String, List<JobSkill>> groupedJobSkills = jobSkillPage.getContent().stream()
                .collect(Collectors.groupingBy(js -> js.getJob().getId()));

        List<JobSkillListResponse> responses = groupedJobSkills.entrySet().stream()
                .map(entry -> jobSkillMapper.mapToJobSkillListResponse(
                        entry.getKey(),
                        entry.getValue().get(0).getJob().getName(),
                        entry.getValue().get(0).getJob().getDescription(),
                        entry.getValue().stream().map(js -> new SkillResponse(
                                js.getSkill().getId(),
                                js.getSkill().getSkillName(),
                                js.getSkill().getType(),
                                js.getSkill().getSkillDescription()
                        )).collect(Collectors.toList()),
                        entry.getValue().get(0).getSkillLevel(),
                        entry.getValue().get(0).getMoreInfo(),
                        entry.getValue().get(0).getCreatedAt(),
                        entry.getValue().get(0).getUpdatedAt()
                ))
                .collect(Collectors.toList());

        return new PageImpl<>(responses, pageable, jobSkillPage.getTotalElements());
    }

    private JobSkillListResponse mapJobSkillsToResponse(List<JobSkill> jobSkills) {
        if (jobSkills.isEmpty()) {
            return null;
        }

        Job job = jobSkills.get(0).getJob();
        List<SkillResponse> skillResponses = jobSkills.stream()
                .map(js -> new SkillResponse(
                        js.getSkill().getId(),
                        js.getSkill().getSkillName(),
                        js.getSkill().getType(),
                        js.getSkill().getSkillDescription()))
                .distinct()
                .collect(Collectors.toList());

        return new JobSkillListResponse(
                job.getId(),
                job.getName(),
                job.getDescription(),
                skillResponses,
                jobSkills.get(0).getSkillLevel(),
                jobSkills.get(0).getMoreInfo(),
                jobSkills.get(0).getCreatedAt(),
                jobSkills.get(0).getUpdatedAt()
        );
    }

    @Override
    @PreAuthorize("hasRole('USER_COMPANY') and @claimsExtractor.getClaim('sub').toString() == authentication.name")
    public JobSkillResponse createJobSkill(JobSkillCreateRequest request, String jobId) {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_EXISTED));
        var skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
        jobSkillRepository.findById(new JobSkillId(skill, job))
                .ifPresent(exist -> {
                    throw new AppException(ErrorCode.JOB_SKILL_EXISTED);
                });
        var jobSkill = JobSkill.builder()
                .job(job)
                .skill(skill)
                .skillLevel(request.getSkillLevel())
                .moreInfo(request.getMoreInfo())
                .build();
        jobSkill = jobSkillRepository.save(jobSkill);

        return jobSkillMapper.toJobSkillResponse(jobSkill);
    }

    @Override
    @Transactional
    public List<JobSkillResponse> createListJobSkill(List<JobSkillCreateRequest> requests, String jobId) {
        List<JobSkill> savedJobSkills = new ArrayList<>();
        for (JobSkillCreateRequest request : requests) {
            var job = jobRepository.findById(jobId).orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_EXISTED));
            var skill = skillRepository.findById(request.getSkillId())
                    .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
            jobSkillRepository.findById(new JobSkillId(skill, job))
                    .ifPresent(exist -> {
                        throw new AppException(ErrorCode.JOB_SKILL_EXISTED);
                    });
            var jobSkill = JobSkill.builder()
                    .job(job)
                    .skill(skill)
                    .skillLevel(request.getSkillLevel())
                    .moreInfo(request.getMoreInfo())
                    .build();
            jobSkill = jobSkillRepository.save(jobSkill);
            savedJobSkills.add(jobSkill);
        }
        return savedJobSkills.stream().map(jobSkillMapper::toJobSkillResponse)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasRole('USER_COMPANY') and @claimsExtractor.getClaim('sub').toString() == authentication.name")
    public JobSkillResponse updateJobSkill(String jobId, String skillId, JobSkillUpdateRequest request) {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_EXISTED));
        var skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));

        var jobSkill = jobSkillRepository.findById(new JobSkillId(skill, job))
                .orElseThrow(() -> new AppException(ErrorCode.JOB_SKILL_NOT_EXISTED));

        jobSkillMapper.updateRequestToJobSkill(request, jobSkill);
        jobSkill = jobSkillRepository.save(jobSkill);
        return jobSkillMapper.toJobSkillResponse(jobSkill);
    }

    @Override
    @PreAuthorize("hasRole('USER_COMPANY_ROLE')")
    public void deleteJobSkill(String jobId, String skillId) {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_EXISTED));
        var skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
        var jobSkill = jobSkillRepository.findById(new JobSkillId(skill, job))
                .orElseThrow(() -> new AppException(ErrorCode.JOB_SKILL_NOT_EXISTED));
        jobSkillRepository.delete(jobSkill);
    }
}
