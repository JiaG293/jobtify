package com.jobtify.model.mapper;

import com.jobtify.dto.request.UserCreateRequest;
import com.jobtify.dto.request.UserUpdateRequest;
import com.jobtify.dto.response.UserResponse;
import com.jobtify.model.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User toUser(UserCreateRequest request);

    @Mapping(target = "email", source = "email", qualifiedByName = "maskEmail")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "maskPhone")
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    @Named("maskEmail")
    default String maskEmail(String email) {
        if (email != null && email.contains("@")) {
            String[] parts = email.split("@");
            String localPart = parts[0];
            String domain = parts[1];

            int length = localPart.length();

            if (length <= 2) {
                return "***" + "@" + domain;
            }
            String firstTwoChars = localPart.substring(0, 2);
            String lastTwoChars = localPart.substring(length - 2);
            String maskedPart = firstTwoChars + "***" + lastTwoChars;
            return maskedPart + "@" + domain;
        }
        return email;
    }


    @Named("maskPhone")
    default String maskPhone(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() > 8) {
            // Giữ lại 4 ký tự đầu và 4 ký tự cuối, ẩn 4 ký tự ở giữa
            return phoneNumber.substring(0, 4) + "**" + phoneNumber.substring(phoneNumber.length() - 2);
        }
        return phoneNumber;
    }
}
