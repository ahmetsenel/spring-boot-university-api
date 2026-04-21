package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.service.impl.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ApiResponse<DepartmentDetail> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        return ApiResponse.ok(departmentService.createDepartment(departmentRequest));
    }

    @GetMapping
    public ApiResponse<List<DepartmentSummary>> getAllDepartments() {
        return ApiResponse.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ApiResponse<DepartmentDetail> getDepartmentById(@PathVariable Long id) {
        return ApiResponse.ok(departmentService.getDepartmentDetailById(id));
    }

    @GetMapping("/{id}/students")
    public ApiResponse<List<StudentSummary>> getDepartmentStudents(@PathVariable Long id) {
        return ApiResponse.ok(departmentService.getDepartmentStudents(id));
    }

    @GetMapping("/{id}/lecturers")
    public ApiResponse<List<LecturerSummary>> getDepartmentLecturers(@PathVariable Long id) {
        return ApiResponse.ok(departmentService.getDepartmentLecturers(id));
    }

    @GetMapping("/{id}/courses")
    public ApiResponse<List<CourseSummary>> getDepartmentCourses(@PathVariable Long id) {
        return ApiResponse.ok(departmentService.getDepartmentCourses(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ApiResponse.ok("Department deleted", null);
    }
}
