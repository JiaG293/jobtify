package com.jobtify.dto.response;

import com.jobtify.model.entity.Job;
import com.jobtify.model.entity.Skill;
import com.jobtify.model.enums.SkillLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobSkillListResponse {
    String id;
    String name;
    String description;
    List<SkillResponse> skills = new ArrayList<>();
    SkillLevel skillLevel;
    String moreInfo;
    LocalDateTime updatedAt;
    LocalDateTime createdAt;
}
