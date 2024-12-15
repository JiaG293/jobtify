package com.jobtify.model.entity;

import com.jobtify.model.enums.SkillLevel;
import com.jobtify.model.ids.CandidateSkillId;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "candidate_skill", schema = "jobtify_service")
@IdClass(CandidateSkillId.class)
@EntityListeners(AuditingEntityListener.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    Candidate candidate;

    @Column(name = "skill_level", nullable = false)
    SkillLevel skillLevel;
    @Column(name = "more_infos", length = 1000)
    String moreInfo;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

}