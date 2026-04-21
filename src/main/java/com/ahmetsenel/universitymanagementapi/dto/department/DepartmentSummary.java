package com.ahmetsenel.universitymanagementapi.dto.department;

import com.ahmetsenel.universitymanagementapi.dto.SummaryDto;
import lombok.Data;

@Data
public class DepartmentSummary extends SummaryDto {

    private String name;
}
