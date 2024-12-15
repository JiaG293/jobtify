package com.jobtify.dto.response;

import com.jobtify.model.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobCompanyResponse {
    String id;
    AddressCompanyResponse address;
    CompanyResponse company;

    List<JobSkillResponse> jobSkills;
}
