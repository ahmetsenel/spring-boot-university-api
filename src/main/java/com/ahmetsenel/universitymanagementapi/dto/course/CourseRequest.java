package com.ahmetsenel.universitymanagementapi.dto.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Code cannot be empty")
    @Size(min = 6, max = 6, message = "SCode must be 6 characters")
    private String code;

    @NotNull(message = "Credit is required")
    private Integer credit;

    @NotNull(message = "Department ID is required")
    @Min(value = 1, message = "Department ID must be a positive number")
    private Long departmentId;

    @NotNull(message = "Lecturer ID is required")
    @Min(value = 1, message = "Lecturer ID must be a positive number")
    private Long lecturerId;
}
