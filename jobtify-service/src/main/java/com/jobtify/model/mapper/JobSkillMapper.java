package com.jobtify.model.mapper;

import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.request.JobSkillCreateRequest;
import com.jobtify.dto.request.JobSkillUpdateRequest;
import com.jobtify.dto.response.JobSkillListResponse;
import com.jobtify.dto.response.JobSkillResponse;
import com.jobtify.dto.response.SkillResponse;
import com.jobtify.model.entity.JobSkill;
import com.jobtify.model.entity.Skill;
import com.jobtify.model.enums.SkillLevel;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface JobSkillMapper {
    JobSkill toJobSkill(JobSkillCreateRequest request);

    /*@Mapping(target = "skill", source = "skill")
    @Mapping(target = "candidateId", source = "candidate.id")*/
    JobSkillResponse toJobSkillResponse(JobSkill jobSkill);

    /*@Mapping(target = "skill", ignore = true)
    @Mapping(target = "candidate", ignore = true)*/
    void updateRequestToJobSkill(JobSkillUpdateRequest request, @MappingTarget JobSkill jobSkill);

    List<JobSkill> toJobSkills(List<JobSkillCreateRequest> requests);

    @Mappings({
            @Mapping(target = "id", source = "jobId"),
            @Mapping(target = "name", source = "jobName"),
            @Mapping(target = "description", source = "jobDescription"),
            @Mapping(target = "skills", source = "skills"),
            @Mapping(target = "skillLevel", source = "skillLevel"),
            @Mapping(target = "moreInfo", source = "moreInfo"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt")
    })
    JobSkillListResponse mapToJobSkillListResponse(
            String jobId,
            String jobName,
            String jobDescription,
            List<SkillResponse> skills,
            SkillLevel skillLevel,
            String moreInfo,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    );
}
