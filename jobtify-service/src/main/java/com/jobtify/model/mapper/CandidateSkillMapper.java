package com.jobtify.model.mapper;

import com.jobtify.dto.request.CandidateSkillCreateRequest;
import com.jobtify.dto.request.CandidateSkillUpdateRequest;
import com.jobtify.dto.response.CandidateSkilListResponse;
import com.jobtify.dto.response.CandidateSkillResponse;
import com.jobtify.model.entity.CandidateSkill;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateSkillMapper {

    CandidateSkill toCandidateSkill(CandidateSkillCreateRequest request);

    @Mapping(target = "skill", source = "skill")
    @Mapping(target = "candidateId", source = "candidate.id")
    CandidateSkillResponse toCandidateSkillResponse(CandidateSkill candidateSkill);

    @Mapping(target = "skill", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    void updateRequestToCandidateSkill(CandidateSkillUpdateRequest request, @MappingTarget CandidateSkill candidateSkill);

    default CandidateSkilListResponse toCandidateSkillListResponse(CandidateSkill candidateSkill) {
        return CandidateSkilListResponse.builder()
                .id(candidateSkill.getSkill().getId())
                .skillName(candidateSkill.getSkill().getSkillName())
                .skillDescription(candidateSkill.getSkill().getSkillDescription())
                .type(candidateSkill.getSkill().getType())
                .skillLevel(candidateSkill.getSkillLevel())
                .moreInfo(candidateSkill.getMoreInfo())
                .build();
    }
}