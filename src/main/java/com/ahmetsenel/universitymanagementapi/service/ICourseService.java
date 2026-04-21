package com.ahmetsenel.universitymanagementapi.service;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseDetail;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseRequest;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Course;

import java.util.List;

public interface ICourseService {

    CourseDetail createCourse(CourseRequest courseRequest);

    Course getCourseById(Long id);

    List<CourseSummary> getAllCourses();

    CourseDetail getCourseDetailById(Long id);

    List<StudentSummary> getCourseStudents(Long id);

    void deleteCourse(Long id);

}
