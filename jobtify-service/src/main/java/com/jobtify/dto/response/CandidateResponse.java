package com.jobtify.dto.response;

import com.jobtify.model.enums.SkillLevel;
import com.neovisionaries.i18n.CountryCode;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.jobtify.model.entity.Candidate}
 */
@Value
public class CandidateResponse implements Serializable {
    String id;
    String fullName;
    LocalDate dob;
    AddressResponse address;
    String phone;
    String email;
    int status;
    List<ExperienceResponse> experiences;
    List<CandidateSkillDto> candidateSkills;
    /**
     * DTO for {@link com.jobtify.model.entity.Address}
     */
    @Value
    public static class AddressResponse implements Serializable {
        String number;
        String street;
        String city;
        String zipcode;
        CountryCode country;
    }

    /**
     * DTO for {@link com.jobtify.model.entity.Experience}
     */
    @Value
    public static class ExperienceResponse implements Serializable {
        String companyName;
        LocalDate fromDate;
        LocalDate toDate;
        String role;
        String workDescription;
    }

    /**
     * DTO for {@link com.jobtify.model.entity.CandidateSkill}
     */
    @Value
    public static class CandidateSkillDto implements Serializable {
        SkillLevel skillLevel;
        String moreInfo;
    }
}