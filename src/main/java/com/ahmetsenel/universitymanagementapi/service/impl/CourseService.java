package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseDetail;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseRequest;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Course;
import com.ahmetsenel.universitymanagementapi.entity.Department;
import com.ahmetsenel.universitymanagementapi.entity.Enrollment;
import com.ahmetsenel.universitymanagementapi.entity.Lecturer;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.mapper.CourseMapper;
import com.ahmetsenel.universitymanagementapi.mapper.StudentMapper;
import com.ahmetsenel.universitymanagementapi.repository.CourseRepository;
import com.ahmetsenel.universitymanagementapi.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    @Override
    public CourseDetail createCourse(CourseRequest courseRequest) {
        Department department = departmentService.getDepartmentById(courseRequest.getDepartmentId());
        Lecturer lecturer = lecturerService.getLecturerById(courseRequest.getLecturerId());

        Course course = courseMapper.toEntity(courseRequest);
        course.setDepartment(department);
        course.setLecturer(lecturer);

        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDetail(savedCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(()-> new BaseException(MessageType.COURSE_NOT_FOUND, id));
    }

    @Override
    public List<CourseSummary> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toSummary)
                .toList();
    }

    @Override
    public CourseDetail getCourseDetailById(Long id) {
        return courseMapper.toDetail(getCourseById(id));
    }

    @Override
    public List<StudentSummary> getCourseStudents(Long id) {
        Course course = getCourseById(id);
        return course.getEnrollments()
                .stream()
                .map(Enrollment::getStudent)
                .map(studentMapper::toSummary)
                .toList();
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}
