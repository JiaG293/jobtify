package com.jobtify.service;


import com.jobtify.dto.request.SkillCreateRequest;
import com.jobtify.dto.request.SkillUpdateRequest;
import com.jobtify.dto.response.SkillResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService {
    SkillResponse createSkillBase(SkillCreateRequest request);
    SkillResponse updateSkill(String skillId, SkillUpdateRequest request);
    Page<SkillResponse> findAll(int page, int limit, String sortBy, String sortDirection);
    Page<SkillResponse> findPaginated(Pageable pageable);
    void deleteSkill(String skillId);
}
