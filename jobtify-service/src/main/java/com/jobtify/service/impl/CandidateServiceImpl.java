package com.jobtify.service.impl;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Candidate;
import com.jobtify.model.mapper.CandidateMapper;
import com.jobtify.service.CandidateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CandidateServiceImpl implements CandidateService {

    CandidateMapper candidateMapper;

    @Override
    public Candidate createCandidateEvent(CreateUserEvent event) {
        var candidate = candidateMapper.eventToCandidate(event);
        log.info("Listen event user-create-topic: {}", candidate);
        return candidate;
    }


}
