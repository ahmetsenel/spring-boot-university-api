package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.AdvisorRequest;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentDetail;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentRequest;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.*;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.mapper.CourseMapper;
import com.ahmetsenel.universitymanagementapi.mapper.StudentMapper;
import com.ahmetsenel.universitymanagementapi.repository.StudentRepository;
import com.ahmetsenel.universitymanagementapi.security.SecurityService;
import com.ahmetsenel.universitymanagementapi.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final LecturerService lecturerService;
    private final DepartmentService departmentService;
    private final SecurityService securityService;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final AuthService authService;

    @Override
    public StudentDetail createStudent(StudentRequest studentRequest) {
        Lecturer lecturer = lecturerService.getLecturerById(studentRequest.getAdvisorId());
        Department department = departmentService.getDepartmentById(studentRequest.getDepartmentId());
        User user = authService.getUserById(studentRequest.getUserId());

        Student student = studentMapper.toEntity(studentRequest);
        student.setAdvisor(lecturer);
        student.setDepartment(department);
        student.setUser(user);

        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDetail(savedStudent);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new BaseException(MessageType.STUDENT_NOT_FOUND, id));
    }

    @Override
    public List<StudentSummary> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toSummary)
                .toList();
    }

    @Override
    public StudentDetail getStudentDetailById(Long id) {
        StudentDetail studentDetail = studentMapper.toDetail(getStudentById(id));
        studentDetail.setCourses(getStudentCourses(id));
        return studentDetail;
    }

    @Override
    public List<CourseSummary> getStudentCourses(Long id) {
        Student student = getStudentById(id);
        return student.getEnrollments()
                .stream()
                .map(Enrollment::getCourse)
                .map(courseMapper::toSummary)
                .toList();
    }

    @Override
    @Transactional
    public StudentDetail updateAdvisor(Long studentId, AdvisorRequest advisorRequest) {
        Student student = getStudentById(studentId);
        Lecturer lecturer = lecturerService.getLecturerById(advisorRequest.getAdvisorId());
        student.setAdvisor(lecturer);
        return studentMapper.toDetail(student);
    }

    @Override
    public StudentDetail getMyStudentDetail() {

        Long userId = securityService.getCurrentUserId();

        Student student = studentRepository.findByUserId(userId)
                .orElseThrow(() -> new BaseException(MessageType.STUDENT_NOT_FOUND));

        StudentDetail studentDetail = studentMapper.toDetail(student);
        studentDetail.setCourses(getStudentCourses(student.getId()));
        return studentDetail;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
