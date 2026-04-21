package com.ahmetsenel.universitymanagementapi.dto.department;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDetail extends DetailDto {

    private String name;

    private List<LecturerSummary> lecturers;

    private List<CourseSummary> courses;

    private List<StudentSummary> students;
}
