package com.jobtify.repository;

import com.jobtify.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SkillRepository extends JpaRepository<Skill, String>, JpaSpecificationExecutor<Skill> {
    Optional<Skill> findAllBySkillName(String skillName);

}