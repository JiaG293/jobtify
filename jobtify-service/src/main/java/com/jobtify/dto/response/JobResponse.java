package com.jobtify.dto.response;

import com.jobtify.dto.request.JobSkillCreateRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    String id;
    String name;
    String description;
    List<JobSkillResponse> jobSkills;
}
