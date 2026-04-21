package com.ahmetsenel.universitymanagementapi.dto.course;

import com.ahmetsenel.universitymanagementapi.dto.SummaryDto;
import lombok.Data;

@Data
public class CourseSummary extends SummaryDto {

    private String name;

    private String code;
}
