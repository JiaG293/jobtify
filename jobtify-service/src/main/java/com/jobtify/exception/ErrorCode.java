package com.jobtify.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    TOKEN_INVALID(1009, "Token invalid verify", HttpStatus.UNAUTHORIZED),
    SKILL_NAME_EXISTED(1010, "Skill name is existed please change name", HttpStatus.CONFLICT),
    SKILL_NOT_EXISTED(1011, "Skill id not existed", HttpStatus.NOT_FOUND),
    CANDIDATE_SKILL_EXISTED(1012, "Candidate skill is existed", HttpStatus.CONFLICT),
    CANDIDATE_SKILL_NOT_EXISTED(1013, "Candidate skill is not existed", HttpStatus.NOT_FOUND),
    JOB_NOT_EXISTED(1014, "", HttpStatus.NOT_FOUND),
    JOB_EXISTED(1015, "", HttpStatus.CONFLICT),
    JOB_SKILL_EXISTED(1016, "Job skill is existed", HttpStatus.CONFLICT),
    JOB_SKILL_NOT_EXISTED(1017, "Job skill is not existed", HttpStatus.NOT_FOUND),
    EXPERIENCE_EXISTED(1018, "Experience is existed", HttpStatus.CONFLICT),
    EXPERIENCE_NOT_EXISTED(1019, "Experience is not existed", HttpStatus.NOT_FOUND),
    CONFLICT_DELETE(1019, "Conflict when delete data", HttpStatus.CONFLICT);



    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}