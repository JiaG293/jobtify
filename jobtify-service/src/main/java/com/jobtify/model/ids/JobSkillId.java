package com.jobtify.model.ids;

import com.jobtify.model.entity.Job;
import com.jobtify.model.entity.Skill;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobSkillId implements Serializable {
    static final long serialVersionUID = 7526661924499644765L;
    Skill skill;
    Job job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobSkillId that = (JobSkillId) o;

        if (!skill.equals(that.skill)) return false;
        return job.equals(that.job);
    }

    @Override
    public int hashCode() {
        int result = skill.hashCode();
        result = 31 * result + job.hashCode();
        return result;
    }

}