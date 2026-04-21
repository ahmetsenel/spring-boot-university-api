package com.ahmetsenel.universitymanagementapi.dto.enrollment;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.entity.enums.Grade;
import lombok.Data;

@Data
public class EnrollmentDto {

    private CourseSummary course;

    private Integer semester;

    private Grade grade;
}
