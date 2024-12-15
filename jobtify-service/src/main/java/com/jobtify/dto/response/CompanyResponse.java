package com.jobtify.dto.response;

import com.jobtify.model.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyResponse {
    String id;
    String name;
    AddressCompanyResponse address;
    String webURL;
    String phone;
    String email;
    String about;

}
