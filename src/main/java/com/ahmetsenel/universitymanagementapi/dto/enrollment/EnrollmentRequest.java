package com.ahmetsenel.universitymanagementapi.dto.enrollment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentRequest {

    @NotNull(message = "Semester is required")
    private Integer semester;

    @NotNull(message = "Student ID is required")
    @Min(value = 1, message = "Student ID must be a positive number")
    private Long studentId;

    @NotNull(message = "Course ID is required")
    @Min(value = 1, message = "Course ID must be a positive number")
    private Long courseId;

}
