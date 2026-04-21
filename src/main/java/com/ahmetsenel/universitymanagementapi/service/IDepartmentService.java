package com.ahmetsenel.universitymanagementapi.service;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Department;

import java.util.List;

public interface IDepartmentService {

    DepartmentDetail createDepartment(DepartmentRequest departmentRequest);

    Department getDepartmentById(Long id);

    List<DepartmentSummary> getAllDepartments();

    DepartmentDetail getDepartmentDetailById(Long id);

    List<StudentSummary> getDepartmentStudents(Long id);

    List<LecturerSummary> getDepartmentLecturers(Long id);

    List<CourseSummary> getDepartmentCourses(Long id);

    void deleteDepartment(Long id);
}
