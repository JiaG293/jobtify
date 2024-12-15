package com.jobtify.model.mapper;

import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    Address eventToAddress(CreateUserEvent event);

}
