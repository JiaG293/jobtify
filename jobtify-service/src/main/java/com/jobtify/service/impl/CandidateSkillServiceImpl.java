package com.jobtify.service.impl;

import com.jobtify.dto.request.CandidateSkillCreateRequest;
import com.jobtify.dto.request.CandidateSkillUpdateRequest;
import com.jobtify.dto.response.CandidateSkilListResponse;
import com.jobtify.dto.response.CandidateSkillResponse;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.ids.CandidateSkillId;
import com.jobtify.model.mapper.CandidateSkillMapper;
import com.jobtify.repository.CandidateRepository;
import com.jobtify.repository.CandidateSkillRepository;
import com.jobtify.repository.SkillRepository;
import com.jobtify.service.CandidateSkillService;
import com.jobtify.config.ClaimsExtractor;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CandidateSkillServiceImpl implements CandidateSkillService {
    CandidateSkillRepository candiateSkillRepository;
    CandidateRepository candidateRepository;
    CandidateSkillMapper candidateSkillMapper;
    ClaimsExtractor claimsExtractor;
    CandidateSkillRepository candidateSkillRepository;
    SkillRepository skillRepository;

    @Override
    public CandidateSkillResponse createCandidateSkill(CandidateSkillCreateRequest request) {
        var candidate = candidateRepository.findById(claimsExtractor.getClaim("uid").toString())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        var skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
        var candidateSkillId = CandidateSkillId.builder()
                .candidate(candidate)
                .skill(skill)
                .build();
        candiateSkillRepository.findById(candidateSkillId)
                .ifPresent(exist -> {
                    throw new AppException(ErrorCode.CANDIDATE_SKILL_EXISTED);
                });

        var candidateSkill = candidateSkillMapper.toCandidateSkill(request);

        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);

        candidateSkill = candidateSkillRepository.save(candidateSkill);

        return candidateSkillMapper.toCandidateSkillResponse(candidateSkill);
    }


    @Override
    public List<CandidateSkilListResponse> findAllMyCandidateSkill() {
        String candidateId = claimsExtractor.getClaim("uid").toString();
        var candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return candidate.getCandidateSkills()
                .stream()
                .map(candidateSkill ->
                        candidateSkillMapper.toCandidateSkillListResponse(candidateSkill))
                .collect(Collectors.toList());
    }

    @Override
    public CandidateSkillResponse updateCandidateSkill(CandidateSkillUpdateRequest request) {
        var candidate = candidateRepository.findById(claimsExtractor.getClaim("uid").toString())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        var skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
        var candidateSkill = candidateSkillRepository.findById(CandidateSkillId.builder()
                        .candidate(candidate)
                        .skill(skill)
                        .build())
                .orElseThrow(() -> new AppException(ErrorCode.CANDIDATE_SKILL_NOT_EXISTED));
        candidateSkillMapper.updateRequestToCandidateSkill(request, candidateSkill);
        return candidateSkillMapper.toCandidateSkillResponse(candiateSkillRepository.save(candidateSkill));
    }
}
