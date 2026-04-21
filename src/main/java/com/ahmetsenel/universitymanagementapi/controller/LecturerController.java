package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerDetail;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerRequest;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.service.impl.LecturerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    @PostMapping
    public ApiResponse<LecturerDetail> createLecturer(@Valid @RequestBody LecturerRequest lecturerRequest) {
        return ApiResponse.ok(lecturerService.createLecturer(lecturerRequest));
    }

    @GetMapping
    public ApiResponse<List<LecturerSummary>> getAllLecturer() {
        return ApiResponse.ok(lecturerService.getAllLecturers());
    }

    @GetMapping("/{id}")
    public ApiResponse<LecturerDetail> getLecturerById(@PathVariable Long id) {
        return ApiResponse.ok(lecturerService.getLecturerDetailById(id));
    }

    @GetMapping("/{id}/courses")
    public ApiResponse<List<CourseSummary>> getCoursesOfLecturer(@PathVariable Long id) {
        return ApiResponse.ok(lecturerService.getCoursesOfLecturer(id));
    }

    @GetMapping("/{id}/students")
    public ApiResponse<List<StudentSummary>> getStudentsOfLecturer(@PathVariable Long id) {
        return ApiResponse.ok(lecturerService.getStudentsOfLecturer(id));
    }

    @GetMapping("/me")
    public ApiResponse<LecturerDetail> getMyLecturerDetail() {
        return ApiResponse.ok(lecturerService.getMyLecturerDetail());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteLecturer(@PathVariable Long id) {
        lecturerService.deleteLecturer(id);
        return ApiResponse.ok("Lecturer deleted", null);
    }
}
