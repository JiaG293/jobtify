package com.jobtify.model.mapper;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Address;
import com.jobtify.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "address", source= "event")
    Company eventToCompany(CreateUserEvent event);

    default Address mapToAddress(CreateUserEvent event) {
        if (event == null) {
            return null;
        }
        return Address.builder()
//                .id(UUID.randomUUID().toString())
                .city(event.getCity())
                .country(event.getCountry())
                .number(event.getNumber())
                .zipcode(event.getZipcode())
                .street(event.getStreet())
                .build();
    }
}
