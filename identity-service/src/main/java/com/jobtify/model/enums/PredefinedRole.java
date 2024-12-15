package com.jobtify.model.enums;

public enum PredefinedRole {
    USER_CANDIDATE("USER_CANDIDATE"),
    USER_COMPANY("USER_COMPANY"),
    ADMIN("ADMIN");

    private final String roleName;

    PredefinedRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
