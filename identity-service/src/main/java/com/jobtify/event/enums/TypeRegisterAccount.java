package com.jobtify.event.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeRegisterAccount {
    COMPANY("COMPANY"),
    CANDIDATE("CANDIDATE");

    private final String type;

    TypeRegisterAccount(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TypeRegisterAccount fromString(String type) {
        if (type != null) {
            type = type.toUpperCase();
        }

        for (TypeRegisterAccount typeRegisterAccount : TypeRegisterAccount.values()) {
            if (typeRegisterAccount.getType().equals(type)) {
                return typeRegisterAccount;
            }
        }

        throw new IllegalArgumentException("Unknown value: " + type);
    }
}
