package com.jobtify.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDetailResponse {
    String id;
    String name;
    String description;
    CompanyResponse company;
    List<JobSkillDetailResponse> jobSkills;
}
