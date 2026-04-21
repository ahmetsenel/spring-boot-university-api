package com.ahmetsenel.universitymanagementapi.mapper;

import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentSummary;
import com.ahmetsenel.universitymanagementapi.dto.enrollment.EnrollmentDto;
import com.ahmetsenel.universitymanagementapi.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, CourseMapper.class})
public interface EnrollmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Enrollment toEntity(EnrollmentRequest enrollmentRequest);

    EnrollmentSummary toSummary(Enrollment enrollment);

    EnrollmentDetail toDetail(Enrollment enrollment);

    EnrollmentDto toDto(Enrollment enrollment);

}
