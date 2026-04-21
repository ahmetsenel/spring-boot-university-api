package com.ahmetsenel.universitymanagementapi.mapper;

import com.ahmetsenel.universitymanagementapi.dto.course.CourseDetail;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseRequest;
import com.ahmetsenel.universitymanagementapi.dto.course.CourseSummary;
import com.ahmetsenel.universitymanagementapi.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, LecturerMapper.class})
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Course toEntity(CourseRequest courseRequest);

    CourseSummary toSummary(Course course);

    CourseDetail toDetail(Course course);

}
