package com.jobtify.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "experience", schema = "jobtify_service")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exp_id")
    String id;
    @Column(name = "company",nullable = false, length = 120)
    String companyName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "from_date",nullable = false)
    LocalDate fromDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "to_date",nullable = false)
    LocalDate toDate;
    @Column(name = "role",nullable = false, length = 100)
    String role;
    @Column(name = "work_desc",nullable = false, length = 400)
    String workDescription;



    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    @JsonIgnore
    Candidate candidate;

}