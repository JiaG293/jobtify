package com.jobtify.dto.response;

import com.jobtify.model.enums.SkillLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateSkillResponse {
    String candidateId;
    SkillResponse skill;
    SkillLevel skillLevel;
    String moreInfo;

}