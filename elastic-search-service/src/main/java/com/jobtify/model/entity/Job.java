package com.jobtify.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "jobs")
public class Job {
    @Id
    private String jobId;
    private String jobName;
    private String jobDesc;

    @DBRef
    private Company company;

    private List<JobSkill> requiredSkills;
}
