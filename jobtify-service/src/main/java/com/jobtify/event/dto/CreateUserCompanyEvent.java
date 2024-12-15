package com.jobtify.event.dto;

import com.jobtify.event.enums.TypeRegisterAccount;
import com.neovisionaries.i18n.CountryCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserCompanyEvent {
    String userId;
    String username;
    String password;
    String email;
    String phone;
    String fullName;

    //type register
    TypeRegisterAccount type;

    //address info
    CountryCode country;
    String number;
    String street;
    String city;
    String zipcode;

    //company
    String emailInfo;
    String webURL;
    String name; //comp_name
    String about;
}
