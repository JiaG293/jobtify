package com.jobtify.repository;

import com.jobtify.model.entity.CandidateSkill;
import com.jobtify.model.ids.CandidateSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId>, JpaSpecificationExecutor<CandidateSkill> {

}