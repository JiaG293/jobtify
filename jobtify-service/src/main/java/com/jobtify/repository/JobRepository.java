package com.jobtify.repository;

import com.jobtify.model.entity.Job;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    String query = """
                        SELECT DISTINCT js.job_id
                        FROM job_skill js
                        INNER JOIN job j ON js.job_id = j.job_id
                        INNER JOIN candidate_skill cs ON js.skill_id = cs.skill_id
                        WHERE cs.skill_level BETWEEN (js.skill_level - 1) AND (js.skill_level + 1)
                        AND cs.can_id = :canId
            
            """;

    @Query(value = query, nativeQuery = true)
    List<String> findMatchingJobs(@Param("canId") String canId);

    List<Job> findByIdIn(List<String> paginatedJobIds);
}