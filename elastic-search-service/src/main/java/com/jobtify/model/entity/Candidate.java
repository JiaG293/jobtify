package com.jobtify.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "candidates")
public class Candidate {
    @Id
    private String canId;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;
    private String status;

    @DBRef
    private Address address;

    private List<CandidateSkill> skills;
    private List<Experience> experiences;
}

