package com.jobtify.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExperienceCreateRequest {
    String companyName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate fromDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate toDate;
    String role;
    String workDescription;
}
