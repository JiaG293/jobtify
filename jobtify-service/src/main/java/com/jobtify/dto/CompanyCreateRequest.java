package com.jobtify.dto;

import com.jobtify.model.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyCreateRequest {
    String id;
    String name;
    Address address;
    String webURL;
    String phone;
    String email;
    String about;
}