package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseDetail;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseRequest;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.service.impl.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ApiResponse<CourseDetail> createCourse(@Valid @RequestBody CourseRequest courseRequest) {
        return ApiResponse.ok(courseService.createCourse(courseRequest));
    }

    @GetMapping
    public ApiResponse<List<CourseSummary>> getAllCourses() {
        return ApiResponse.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseDetail> getCourseById(@PathVariable Long id) {
        return ApiResponse.ok(courseService.getCourseDetailById(id));
    }

    @GetMapping("/{id}/students")
    public ApiResponse<List<StudentSummary>> getStudentsById(@PathVariable Long id) {
        return ApiResponse.ok(courseService.getCourseStudents(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ApiResponse.ok("Course deleted", null);
    }
}
