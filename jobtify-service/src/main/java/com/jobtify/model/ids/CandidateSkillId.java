package com.jobtify.model.ids;

import com.jobtify.model.entity.Candidate;
import com.jobtify.model.entity.Skill;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateSkillId implements Serializable {
    static final long serialVersionUID = 7526661924499644765L;
    Skill skill;
    Candidate candidate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateSkillId that = (CandidateSkillId) o;

        if (!skill.equals(that.skill)) return false;
        return candidate.equals(that.candidate);
    }

    @Override
    public int hashCode() {
        int result = skill.hashCode();
        result = 31 * result + candidate.hashCode();
        return result;
    }

}