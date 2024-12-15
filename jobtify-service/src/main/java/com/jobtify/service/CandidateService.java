package com.jobtify.service;


import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Candidate;

public interface CandidateService {
    Candidate createCandidateEvent(CreateUserEvent event);


}
