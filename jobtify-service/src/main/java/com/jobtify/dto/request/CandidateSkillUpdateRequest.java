package com.jobtify.dto.request;

import com.jobtify.model.enums.SkillLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Getter
@Builder
@FieldDefaults(level = PRIVATE)
public class CandidateSkillUpdateRequest {
    String skillId;
    SkillLevel skillLevel;
    String moreInfo;
}
