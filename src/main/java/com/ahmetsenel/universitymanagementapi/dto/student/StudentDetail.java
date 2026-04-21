package com.ahmetsenel.universitymanagementapi.dto.student;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDetail extends DetailDto {

    private String firstName;

    private String lastName;

    private String email;

    private String studentNumber;

    private LocalDate birthDate;

    private DepartmentSummary department;

    private LecturerSummary advisor;

    private List<CourseSummary> courses = new ArrayList<>();;
}
