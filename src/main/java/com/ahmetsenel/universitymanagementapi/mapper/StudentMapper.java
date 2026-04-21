package com.ahmetsenel.universitymanagementapi.mapper;

import com.ahmetsenel.universitymanagementapi.dto.student.StudentRequest;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentDetail;
import com.ahmetsenel.universitymanagementapi.dto.student.StudentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, LecturerMapper.class},
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Student toEntity(StudentRequest dto);

    StudentDetail toDetail(Student student);

    StudentSummary toSummary(Student student);
}
