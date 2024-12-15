package com.jobtify.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExperienceResponse {
    String id;
    String companyName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate fromDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate toDate;
    String role;
    String workDescription;
}
