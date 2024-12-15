package com.jobtify.service;

import com.jobtify.dto.request.CandidateSkillCreateRequest;
import com.jobtify.dto.request.CandidateSkillUpdateRequest;
import com.jobtify.dto.response.CandidateSkilListResponse;
import com.jobtify.dto.response.CandidateSkillResponse;

import java.util.List;

public interface CandidateSkillService {
    CandidateSkillResponse createCandidateSkill(CandidateSkillCreateRequest request);
    List<CandidateSkilListResponse> findAllMyCandidateSkill();
    CandidateSkillResponse updateCandidateSkill(CandidateSkillUpdateRequest request);

}
