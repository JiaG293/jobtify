package com.jobtify.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companies")
public class Company {
    @Id
    private String comId;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;
    private String about;

    @DBRef
    private Address address;

    private List<Job> jobs;
}
