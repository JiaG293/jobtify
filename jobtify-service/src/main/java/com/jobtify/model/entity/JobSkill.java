package com.jobtify.model.entity;

import com.jobtify.model.enums.SkillLevel;
import com.jobtify.model.ids.JobSkillId;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "job_skill", schema = "jobtify_service")
@IdClass(JobSkillId.class)
@EntityListeners(AuditingEntityListener.class)
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    Job job;

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