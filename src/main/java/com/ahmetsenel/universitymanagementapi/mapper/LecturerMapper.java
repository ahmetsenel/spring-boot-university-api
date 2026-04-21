package com.ahmetsenel.universitymanagementapi.mapper;

import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerDetail;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerRequest;
import com.ahmetsenel.universitymanagementapi.dto.lecturer.LecturerSummary;
import com.ahmetsenel.universitymanagementapi.entity.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class},
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface LecturerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Lecturer toEntity(LecturerRequest lecturerRequest);

    LecturerSummary toSummary(Lecturer lecturer);

    LecturerDetail toDetail(Lecturer lecturer);
}