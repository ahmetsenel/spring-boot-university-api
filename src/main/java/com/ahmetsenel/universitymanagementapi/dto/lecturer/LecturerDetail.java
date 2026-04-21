package com.ahmetsenel.universitymanagementapi.dto.lecturer;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import lombok.Data;

import java.util.List;

@Data
public class LecturerDetail extends DetailDto {

    private String title;

    private String firstName;

    private String lastName;

    private String email;

    private DepartmentSummary department;

    private List<CourseSummary> courses;

    private List<StudentSummary> students;
}
