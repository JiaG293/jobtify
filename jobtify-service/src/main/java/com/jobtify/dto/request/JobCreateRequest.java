package com.jobtify.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobCreateRequest {
    String name;
    String description;
    List<JobSkillCreateRequest> jobSkills;
}
