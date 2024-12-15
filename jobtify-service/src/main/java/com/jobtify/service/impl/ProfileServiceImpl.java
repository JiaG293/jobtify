package com.jobtify.service.impl;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.event.enums.TypeRegisterAccount;
import com.jobtify.model.mapper.CandidateMapper;
import com.jobtify.model.mapper.CompanyMapper;
import com.jobtify.repository.AddressRepository;
import com.jobtify.repository.CandidateRepository;
import com.jobtify.repository.CompanyRepository;
import com.jobtify.service.ProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ProfileServiceImpl implements ProfileService {
    CompanyRepository companyRepository;
    CandidateRepository candidateRepository;
    AddressRepository addressRepository;

    CandidateMapper candidateMapper;
    CompanyMapper companyMapper;
    private final KafkaTemplate kafkaTemplate;


    @Override
    @Transactional
    public void createProfileEvent(CreateUserEvent event) {
        try {
            if (event.getType().equals(TypeRegisterAccount.CANDIDATE)) {
                var candidateProfile = candidateRepository.save(candidateMapper.eventToCandidate(event));
                candidateProfile.setStatus(1);
            } else {
                companyRepository.save(companyMapper.eventToCompany(event));
            }
        } catch (RuntimeException e) {
            log.error("Error processing event: {}", e.getMessage());
            throw e;
        }


    }


}
