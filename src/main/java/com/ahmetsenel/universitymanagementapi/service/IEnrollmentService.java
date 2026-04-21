package com.ahmetsenel.universitymanagementapi.service;

import com.ahmetsenel.universitymanagementapi.dto.enrollment.*;
import com.ahmetsenel.universitymanagementapi.entity.Enrollment;

import java.util.List;

public interface IEnrollmentService {

    EnrollmentDetail createEnrollment(EnrollmentRequest enrollmentRequest);

    Enrollment getEnrollmentById(Long id);

    List<EnrollmentSummary> getAllEnrollments();

    EnrollmentDetail getEnrollmentDetailById(Long id);

    List<EnrollmentDto> getEnrollmentsByStudentId(Long id);

    EnrollmentDetail updateGrade(Long id, GradeRequest grade);

    void deleteEnrollment(Long id);
}
