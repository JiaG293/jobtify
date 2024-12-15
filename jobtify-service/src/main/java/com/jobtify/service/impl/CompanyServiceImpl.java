package com.jobtify.service.impl;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Company;
import com.jobtify.model.mapper.CompanyMapper;
import com.jobtify.repository.CompanyRepository;
import com.jobtify.service.CompanyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;
    CompanyMapper companyMapper;

    @Override
    public Company createCompanyEvent(CreateUserEvent event) {
        var company = companyMapper.eventToCompany(event);
        log.info("Listen event user-create-topic: {}", company);
        return company;
    }
}
