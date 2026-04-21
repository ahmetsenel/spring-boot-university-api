package com.ahmetsenel.universitymanagementapi.dto.student;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdvisorRequest {

    @NotNull(message = "Advisor ID is required")
    @Min(value = 1, message = "Advisor ID must be a positive number")
    private Long advisorId;
}
