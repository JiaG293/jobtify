package com.jobtify.model.mapper;


import com.jobtify.dto.request.JobCreateRequest;
import com.jobtify.dto.request.JobSkillCreateRequest;
import com.jobtify.dto.request.JobUpdateRequest;
import com.jobtify.dto.response.*;
import com.jobtify.model.entity.Address;
import com.jobtify.model.entity.Company;
import com.jobtify.model.entity.Job;
import com.jobtify.model.entity.JobSkill;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface JobMapper {

    Job toJob(JobCreateRequest request);

    JobResponse toJobResponse(Job job);

    @Mapping(target = "company", source = "company")
    JobDetailResponse toJobDetailResponse(Job job);





    void updateRequestToJob(JobUpdateRequest request, @MappingTarget Job job);


}