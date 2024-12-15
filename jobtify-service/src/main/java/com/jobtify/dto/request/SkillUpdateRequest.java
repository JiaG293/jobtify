package com.jobtify.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobtify.model.enums.SkillType;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillUpdateRequest {

    @Size(min = 1, message = "skill name not empty")
    String skillName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    SkillType type;

    String skillDescription;
}
