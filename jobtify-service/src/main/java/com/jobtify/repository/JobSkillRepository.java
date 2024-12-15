package com.jobtify.repository;

import com.jobtify.dto.response.JobSkillListResponse;
import com.jobtify.model.entity.JobSkill;
import com.jobtify.model.ids.JobSkillId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId>, JpaSpecificationExecutor<JobSkill> {

    List<JobSkill> findByJobId(String jobId);

    List<JobSkill> findBySkillId(String skillId);

    Optional<JobSkill> findByJobIdAndSkillId(String jobId, String skillId);

    @Query("SELECT js FROM JobSkill js JOIN FETCH js.job j JOIN FETCH js.skill s")
    Page<JobSkill> fetchJobSkills(Pageable pageable);

    @Query(value =
            "SELECT DISTINCT js.job_id " +
                    "FROM job_skill js " +
                    "INNER JOIN candidate_skill cs ON js.skill_id = cs.skill_id " +
                    "WHERE cs.can_id = :candidateId", nativeQuery = true)
    List<String> findRelatedJobs(@Param("candidateId") String candidateId);
}