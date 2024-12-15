package com.jobtify.model.enums;

public enum UserFieldTypeCheck {
    EMAIL("email"),
    USERNAME("username"),
    PHONE("phone");

    private final String fieldType;

    UserFieldTypeCheck(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public static boolean isEqual(String value, UserFieldTypeCheck fieldTypeCheck) {
        return fieldTypeCheck.getFieldType().equalsIgnoreCase(value);
    }
}
