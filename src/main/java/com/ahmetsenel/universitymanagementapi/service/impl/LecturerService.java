package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerDetail;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerRequest;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Department;
import com.ahmetsenel.universitymanagementapi.entity.Lecturer;
import com.ahmetsenel.universitymanagementapi.entity.Student;
import com.ahmetsenel.universitymanagementapi.entity.User;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.mapper.CourseMapper;
import com.ahmetsenel.universitymanagementapi.mapper.LecturerMapper;
import com.ahmetsenel.universitymanagementapi.mapper.StudentMapper;
import com.ahmetsenel.universitymanagementapi.repository.LecturerRepository;
import com.ahmetsenel.universitymanagementapi.security.SecurityService;
import com.ahmetsenel.universitymanagementapi.service.ILecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService implements ILecturerService {

    private final LecturerRepository lecturerRepository;
    private final DepartmentService departmentService;
    private final SecurityService securityService;
    private final LecturerMapper lecturerMapper;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final AuthService authService;

    @Override
    public LecturerDetail createLecturer(LecturerRequest lecturerRequest) {
        Department department = departmentService.getDepartmentById(lecturerRequest.getDepartmentId());
        User user = authService.getUserById(lecturerRequest.getUserId());

        Lecturer lecturer = lecturerMapper.toEntity(lecturerRequest);
        lecturer.setDepartment(department);
        lecturer.setUser(user);

        Lecturer savedLecturer = lecturerRepository.save(lecturer);
        return lecturerMapper.toDetail(savedLecturer);
    }

    @Override
    public Lecturer getLecturerById(Long id) {
        return lecturerRepository.findById(id)
                .orElseThrow(()-> new BaseException(MessageType.LECTURER_NOT_FOUND, id));
    }

    @Override
    public List<LecturerSummary> getAllLecturers() {
        return lecturerRepository.findAll()
                .stream()
                .map(lecturerMapper::toSummary)
                .toList();
    }

    @Override
    public LecturerDetail getLecturerDetailById(Long id) {
        return lecturerMapper.toDetail(getLecturerById(id));
    }

    @Override
    public List<CourseSummary> getCoursesOfLecturer (Long lecturerId) {
        Lecturer lecturer = getLecturerById(lecturerId);
        return lecturer.getCourses()
                .stream()
                .map(courseMapper::toSummary)
                .toList();
    }

    @Override
    public List<StudentSummary> getStudentsOfLecturer(Long lecturerId) {
        Lecturer lecturer = getLecturerById(lecturerId);
        return lecturer.getStudents()
                .stream()
                .map(studentMapper::toSummary)
                .toList();
    }

    @Override
    public LecturerDetail getMyLecturerDetail() {

        Long userId = securityService.getCurrentUserId();

        Lecturer lecturer = lecturerRepository.findByUserId(userId)
                .orElseThrow(() -> new BaseException(MessageType.STUDENT_NOT_FOUND));

        return lecturerMapper.toDetail(lecturer);
    }

    @Override
    public void deleteLecturer(Long id) {
        Lecturer lecturer = getLecturerById(id);
        lecturerRepository.delete(lecturer);
    }
}
