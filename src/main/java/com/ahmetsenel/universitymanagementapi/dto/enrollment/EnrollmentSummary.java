package com.ahmetsenel.universitymanagementapi.dto.enrollment;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import lombok.Data;

@Data
public class EnrollmentSummary extends DetailDto {

    private StudentSummary student;

    private CourseSummary course;
}
