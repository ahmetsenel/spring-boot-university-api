package com.ahmetsenel.universitymanagementapi.dto.course;

import com.ahmetsenel.universitymanagementapi.dto.DetailDto;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import lombok.Data;

@Data
public class CourseDetail extends DetailDto {

    private String name;

    private String code;

    private String credit;

    private DepartmentSummary department;

    private LecturerSummary lecturer;
}
