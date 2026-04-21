package com.ahmetsenel.universitymanagementapi.dto.enrollment;

import com.ahmetsenel.universitymanagementapi.entity.enums.Grade;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GradeRequest {

    @NotNull(message = "Grade is required")
    private Grade grade;
}
