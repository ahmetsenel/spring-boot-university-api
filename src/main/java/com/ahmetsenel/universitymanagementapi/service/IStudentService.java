package com.ahmetsenel.universitymanagementapi.service;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.AdvisorRequest;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentDetail;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentRequest;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Student;

import java.util.List;

public interface IStudentService {

    StudentDetail createStudent(StudentRequest studentRequest);

    Student getStudentById(Long id);

    List<StudentSummary> getAllStudents();

    StudentDetail getStudentDetailById(Long id);

    List<CourseSummary> getStudentCourses(Long id);

    StudentDetail updateAdvisor(Long studentId, AdvisorRequest advisorRequest);

    public StudentDetail getMyStudentDetail();

    void deleteStudent(Long id);
}
