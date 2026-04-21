package com.ahmetsenel.universitymanagementapi.dto.enrollment;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.enums.Grade;
import lombok.Data;

@Data
public class EnrollmentDetail extends DetailDto {

    private StudentSummary student;

    private CourseSummary course;

    private Integer semester;

    private Grade grade;
}
