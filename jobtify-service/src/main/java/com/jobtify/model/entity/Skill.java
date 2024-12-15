package com.jobtify.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobtify.model.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "skill", schema = "jobtify_service")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "skill_id")
    String id;
    @Column(name = "skill_name", nullable = false, length = 150)
    String skillName;
    @Column(name = "skill_type", nullable = false)
    SkillType type;
    @Column(name = "skill_desc", nullable = false, length = 300)
    String skillDescription;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<JobSkill> jobSkills;
    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", skillName='" + skillName + '\'' +
                ", type='" + type + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                '}';
    }
}