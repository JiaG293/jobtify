package com.jobtify.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class CandidateSkill {
    @DBRef
    private Skill skill;
    private String skillLevel;
    private String moreInfos;
}
