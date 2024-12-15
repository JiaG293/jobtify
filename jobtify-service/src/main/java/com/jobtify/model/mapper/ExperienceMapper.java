package com.jobtify.model.mapper;


import com.jobtify.dto.request.ExperienceCreateRequest;
import com.jobtify.dto.request.ExperienceUpdateRequest;
import com.jobtify.dto.response.ExperienceResponse;
import com.jobtify.model.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExperienceMapper {

    @Mapping(target = "candidate", ignore = true)
    Experience toExperience(ExperienceCreateRequest request);

    ExperienceResponse toExperienceResponse(Experience experience);


    void updateRequestToExperience(ExperienceUpdateRequest request, @MappingTarget Experience experience);
}
