package com.jobtify.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobtify.model.enums.SkillType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillCreateRequest {
    String skillName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    SkillType type;
    String skillDescription;
}
