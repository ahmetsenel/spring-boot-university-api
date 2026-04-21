package com.ahmetsenel.universitymanagementapi.dto.department;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentRequest {

    @NotBlank(message = "Department cannot be empty")
    private String name;
}
