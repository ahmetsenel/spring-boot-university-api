package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.GradeRequest;
import com.ahmetsenel.universitymanagementapi.service.impl.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ApiResponse<EnrollmentDetail> createEnrollment(@Valid @RequestBody EnrollmentRequest enrollmentRequest) {
        return ApiResponse.ok(enrollmentService.createEnrollment(enrollmentRequest));
    }

    @GetMapping
    public ApiResponse<List<EnrollmentSummary>> getAllEnrollment() {
        return ApiResponse.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ApiResponse<EnrollmentDetail> getEnrollmentById(@PathVariable Long id) {
        return ApiResponse.ok(enrollmentService.getEnrollmentDetailById(id));
    }

    @PatchMapping("/{id}/grade")
    public ApiResponse<EnrollmentDetail> assignGrade(@Valid @PathVariable Long id, @RequestBody GradeRequest grade) {
        return ApiResponse.ok(enrollmentService.updateGrade(id, grade));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ApiResponse.ok("Enrollment deleted", null);
    }
}
