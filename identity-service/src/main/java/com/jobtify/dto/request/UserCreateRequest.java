package com.jobtify.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobtify.event.enums.TypeRegisterAccount;
import com.neovisionaries.i18n.CountryCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    //type register
    TypeRegisterAccount type;

    //candidate info
    String username;
    String password;
    String email;
    String phone;
    String fullName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dob;

    //company info
    String emailInfo;
    String webURL;
    String name; //comp_name
    String about;


    //address info
    CountryCode country;
    String number;
    String street;
    String city;
    String zipcode;





}
