package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Department;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.mapper.CourseMapper;
import com.ahmetsenel.universitymanagementapi.mapper.DepartmentMapper;
import com.ahmetsenel.universitymanagementapi.mapper.LecturerMapper;
import com.ahmetsenel.universitymanagementapi.mapper.StudentMapper;
import com.ahmetsenel.universitymanagementapi.repository.DepartmentRepository;
import com.ahmetsenel.universitymanagementapi.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final StudentMapper studentMapper;
    private final LecturerMapper lecturerMapper;
    private final CourseMapper courseMapper;

    @Override
    public DepartmentDetail createDepartment(DepartmentRequest departmentRequest) {
        Department department = departmentMapper.toEntity(departmentRequest);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDetail(savedDepartment);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new BaseException(MessageType.DEPARTMENT_NOT_FOUND, id));
    }

    @Override
    public List<DepartmentSummary> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toSummary)
                .toList();
    }

    @Override
    public DepartmentDetail getDepartmentDetailById(Long id) {
        return departmentMapper.toDetail(getDepartmentById(id));
    }

    @Override
    public List<StudentSummary> getDepartmentStudents(Long id) {
        Department department = getDepartmentById(id);
        return department.getStudents()
                .stream()
                .map(studentMapper::toSummary)
                .toList();
    }

    @Override
    public List<LecturerSummary> getDepartmentLecturers(Long id) {
        Department department = getDepartmentById(id);
        return department.getLecturers()
                .stream()
                .map(lecturerMapper::toSummary)
                .toList();
    }

    @Override
    public List<CourseSummary> getDepartmentCourses(Long id) {
        Department department = getDepartmentById(id);
        return  department.getCourses()
                .stream()
                .map(courseMapper::toSummary)
                .toList();
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }
}
