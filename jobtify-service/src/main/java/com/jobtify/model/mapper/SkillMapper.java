package com.jobtify.model.mapper;

import com.jobtify.dto.request.SkillCreateRequest;
import com.jobtify.dto.request.SkillUpdateRequest;
import com.jobtify.dto.response.SkillResponse;
import com.jobtify.model.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SkillMapper {
    Skill toSkill(SkillCreateRequest request);

    SkillResponse toSkillResponse(Skill skill);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jobSkills", ignore = true)
    void updateRequestToSkill(SkillUpdateRequest request, @MappingTarget Skill skill);
}
