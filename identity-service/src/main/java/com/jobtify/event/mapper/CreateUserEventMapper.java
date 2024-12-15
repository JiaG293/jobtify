package com.jobtify.event.mapper;

import com.jobtify.dto.request.UserCreateRequest;
import com.jobtify.event.dto.CreateUserEvent;
import com.jobtify.model.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CreateUserEventMapper {
//    @Mapping(target = "userId", ignore = true)
    CreateUserEvent toCreateUserEvent(UserCreateRequest request, String id);

    UserCreateRequest toUserCreateRequest(CreateUserEvent event);

}
