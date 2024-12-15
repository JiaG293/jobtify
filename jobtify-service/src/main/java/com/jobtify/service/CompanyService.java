package com.jobtify.service;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Company;

public interface CompanyService {
    Company createCompanyEvent(CreateUserEvent event);
}
