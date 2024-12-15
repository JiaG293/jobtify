package com.jobtify.service.impl;

import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.request.JobUpdateRequest;
import com.jobtify.dto.response.JobCompanyResponse;
import com.jobtify.dto.response.JobDetailResponse;
import com.jobtify.dto.response.JobResponse;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.entity.Job;
import com.jobtify.model.entity.JobSkill;
import com.jobtify.model.mapper.JobMapper;
import com.jobtify.model.mapper.JobSkillMapper;
import com.jobtify.repository.CompanyRepository;
import com.jobtify.repository.JobRepository;
import com.jobtify.repository.JobSkillRepository;
import com.jobtify.service.JobService;
import com.jobtify.service.JobSkillService;
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
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    ClaimsExtractor claimsExtractor;
    CompanyRepository companyRepository;
    JobMapper jobMapper;
    JobSkillMapper jobSkillMapper;
    JobSkillService jobSkillService;
    private final JobSkillRepository jobSkillRepository;

    @Override
    @PreAuthorize("hasRole('USER_COMPANY') and @claimsExtractor.getClaim('sub').toString() == authentication.name")
    public JobResponse createJob(JobCreateRequest request) {
        log.info("1. job info {}", request);
        var company = companyRepository.findById(claimsExtractor
                        .getClaim("uid").toString())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        var job = jobRepository.save(
                Job.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .company(company)
                        .build()
        );
        var result = jobMapper.toJobResponse(job);
        var jobSkillList = jobSkillService.createListJobSkill(request.getJobSkills(), result.getId());
        result.setJobSkills(jobSkillList);
        return result;
    }

    @Override
    public JobResponse updateJob(String jobId, JobUpdateRequest request) {
        var job = jobRepository.findById(jobId)
                .orElseThrow(() -> new AppException(ErrorCode.EXPERIENCE_NOT_EXISTED));

        jobMapper.updateRequestToJob(request, job);
        job = jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }

    @Override
    public JobCompanyResponse getJobCompanyById(String jobId) {
        return null;
    }

    @Override
    public Page<JobDetailResponse> findAll(int page, int size, String sortBy, String sortDirection) {
        String defaultSortDirection = sortDirection.equalsIgnoreCase("asc") ? sortDirection : "desc";

        Sort sort = Sort.by(Sort.Direction.fromString(defaultSortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Job> jobPage = jobRepository.findAll(pageable).map(job -> job);
        return jobPage.map(job -> jobMapper.toJobDetailResponse(job));
    }


    @Override
    public Page<JobResponse> findPaginated(Pageable pageable) {
        return null;
    }

}
