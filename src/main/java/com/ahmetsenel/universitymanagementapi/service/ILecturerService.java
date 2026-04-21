package com.ahmetsenel.universitymanagementapi.service;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerDetail;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerRequest;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Lecturer;
import com.ahmetsenel.universitymanagementapi.entity.Student;

import java.util.List;

public interface ILecturerService {
    LecturerDetail createLecturer(LecturerRequest lecturerRequest);

    Lecturer getLecturerById(Long id);

    List<LecturerSummary> getAllLecturers();

    LecturerDetail getLecturerDetailById(Long id);

    List<CourseSummary> getCoursesOfLecturer(Long lecturerId);

    List<StudentSummary> getStudentsOfLecturer(Long lecturerId);

    LecturerDetail getMyLecturerDetail();

    void deleteLecturer(Long id);
}
