package com.ahmetsenel.universitymanagementapi.dto.student;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentRequest {

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Student number cannot be empty")
    @Size(min = 9, max = 9, message = "Student number must be 9 characters")
    private String studentNumber;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @NotNull(message = "Department ID is required")
    @Min(value = 1, message = "Department ID must be a positive number")
    private Long departmentId;

    @NotNull(message = "Advisor ID is required")
    @Min(value = 1, message = "Advisor ID must be a positive number")
    private Long advisorId;

    @NotNull(message = "User ID is required")
    @Min(value = 1, message = "User ID must be a positive number")
    private Long userId;
}
