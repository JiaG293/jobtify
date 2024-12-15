package com.jobtify.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
public class Skill {
    @Id
    private String skillId;
    private String skillName;
    private String skillDesc;
    private String skillType;
}
