package com.jobtify.service;

import com.jobtify.dto.request.JobSkillCreateRequest;
import com.jobtify.dto.request.JobSkillUpdateRequest;
import com.jobtify.dto.response.JobSkillListResponse;
import com.jobtify.dto.response.JobSkillResponse;
import com.jobtify.model.ids.JobSkillId;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobSkillService {
    JobSkillResponse getJobSkillResponse(String jobSkillId);
    List<JobSkillListResponse> findAllJobSkill();

    Page<JobSkillListResponse> findAllPageJobSkill(int page, int size, String sortBy, String sortDirection);

    JobSkillResponse createJobSkill(JobSkillCreateRequest request, String jobId);

    List<JobSkillResponse> createListJobSkill(List<JobSkillCreateRequest> request, String jobId);

    JobSkillResponse updateJobSkill(String jobId, String skillId, JobSkillUpdateRequest request);

    void deleteJobSkill(String jobId, String skillId);
}
