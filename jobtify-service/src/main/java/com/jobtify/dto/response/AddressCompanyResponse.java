package com.jobtify.dto.response;

import com.neovisionaries.i18n.CountryCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressCompanyResponse {
    String id;
    CountryCode countryCode;
    String zipcode;
    String number;
    String street;
}
