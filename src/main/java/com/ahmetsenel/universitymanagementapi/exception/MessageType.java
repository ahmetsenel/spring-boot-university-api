package com.ahmetsenel.universitymanagementapi.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    USERNAME_ALREADY_EXIST(1000, "Username already exist: %s"),
    USERNAME_OR_PASSWORD_INVALID(1001, "Username or password invalid: %s %s"),

    USER_NOT_FOUND(2001, "User not found with id: %s"),
    STUDENT_NOT_FOUND(2002, "Student not found with id: %s"),
    COURSE_NOT_FOUND(2003, "Course not found with id: %s"),
    LECTURER_NOT_FOUND(2004, "Lecturer not found with: %s"),
    DEPARTMENT_NOT_FOUND(2005, "Department not found: %s"),
    ENROLLMENT_NOT_FOUND(2006, "Enrollment not found: %s"),
    USER_HAS_NO_STUDENT_PROFILE(9999, "Hata olustu");

    private final Integer code;
    private final String message;

    MessageType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

