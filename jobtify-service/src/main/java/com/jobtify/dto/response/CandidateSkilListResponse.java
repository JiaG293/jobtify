package com.jobtify.dto.response;

import com.jobtify.model.enums.SkillLevel;
import com.jobtify.model.enums.SkillType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateSkilListResponse {
    String id;
    String skillName;
    SkillType type;
    String skillDescription;
    SkillLevel skillLevel;
    String moreInfo;

}