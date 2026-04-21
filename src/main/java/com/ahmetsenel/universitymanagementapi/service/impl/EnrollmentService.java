package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.enrollment.*;
import com.ahmetsenel.universitymanagementapi.entity.Course;
import com.ahmetsenel.universitymanagementapi.entity.Enrollment;
import com.ahmetsenel.universitymanagementapi.entity.Student;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.mapper.EnrollmentMapper;
import com.ahmetsenel.universitymanagementapi.repository.EnrollmentRepository;
import com.ahmetsenel.universitymanagementapi.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements IEnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentDetail createEnrollment(EnrollmentRequest enrollmentRequest) {
        Student student = studentService.getStudentById(enrollmentRequest.getStudentId());
        Course course = courseService.getCourseById(enrollmentRequest.getCourseId());

        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentRequest);
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDetail(savedEnrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(()-> new BaseException(MessageType.ENROLLMENT_NOT_FOUND, id));
    }

    @Override
    public List<EnrollmentSummary> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toSummary)
                .toList();
    }

    @Override
    public EnrollmentDetail getEnrollmentDetailById(Long id) {
        return enrollmentMapper.toDetail(getEnrollmentById(id));
    }

    @Override
    public List<EnrollmentDto> getEnrollmentsByStudentId(Long id) {
        return enrollmentRepository.findEnrollmentsByStudentId(id)
                .stream()
                .map(enrollmentMapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public EnrollmentDetail updateGrade(Long id, GradeRequest grade) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollment.setGrade(grade.getGrade());
        return enrollmentMapper.toDetail(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollmentRepository.delete(enrollment);
    }
}
