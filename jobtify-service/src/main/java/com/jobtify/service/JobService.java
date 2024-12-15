package com.jobtify.service;

import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.request.JobUpdateRequest;
import com.jobtify.dto.response.JobCompanyResponse;
import com.jobtify.dto.response.JobDetailResponse;
import com.jobtify.dto.response.JobResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    JobResponse createJob(JobCreateRequest request);
    JobResponse updateJob(String jobId, JobUpdateRequest request);
    JobCompanyResponse getJobCompanyById(String jobId);
    Page<JobDetailResponse> findAll(int page, int size, String sortBy, String sortDirection);

    Page<JobResponse> findPaginated(Pageable pageable);
}
