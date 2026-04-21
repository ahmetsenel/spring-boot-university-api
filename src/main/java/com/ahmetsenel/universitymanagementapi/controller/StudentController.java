package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentDto;
import com.ahmetsenel.universitymanagementapi.dto.student.*;
import com.ahmetsenel.universitymanagementapi.service.impl.EnrollmentService;
import com.ahmetsenel.universitymanagementapi.service.impl.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @PostMapping
    public ApiResponse<StudentDetail> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return ApiResponse.ok(studentService.createStudent(studentRequest));
    }

    @GetMapping
    public ApiResponse<List<StudentSummary>> getAllStudents() {
        return ApiResponse.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentDetail> getStudentById(@PathVariable Long id) {
        return ApiResponse.ok(studentService.getStudentDetailById(id));
    }

    @GetMapping("/{id}/courses")
    public ApiResponse<List<CourseSummary>> getStudentCourses(@PathVariable Long id) {
        return ApiResponse.ok(studentService.getStudentCourses(id));
    }

    @GetMapping("/{id}/enrollments")
    public ApiResponse<List<EnrollmentDto>> getStudentEnrollments(@PathVariable Long id) {
        return ApiResponse.ok(enrollmentService.getEnrollmentsByStudentId(id));
    }

    @PatchMapping("/{id}/advisor")
    public ApiResponse<StudentDetail> updateAdvisor(@Valid @PathVariable Long id, @RequestBody AdvisorRequest advisorRequest) {
        return ApiResponse.ok(studentService.updateAdvisor(id, advisorRequest));
    }

    @GetMapping("/me")
    public ApiResponse<StudentDetail> getMyStudent() {
        return ApiResponse.ok(studentService.getMyStudentDetail());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ApiResponse.ok("Student deleted", null);
    }
}
