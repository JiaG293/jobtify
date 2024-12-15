package com.jobtify.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "candidate", schema = "jobtify_service")
@EntityListeners(AuditingEntityListener.class)
public class Candidate {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "can_id")
    String id;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    Address address;

    @Column(name = "phone", length = 15, nullable = false, unique = true)
    String phone;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(columnDefinition = "smallint")
    int status = 1;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CandidateSkill> candidateSkills;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;


}