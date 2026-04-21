package com.ahmetsenel.universitymanagementapi.mapper;

import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentDetail;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentRequest;
import com.ahmetsenel.universitymanagementapi.dto.department.DepartmentSummary;
import com.ahmetsenel.universitymanagementapi.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Department toEntity(DepartmentRequest departmentRequest);

    DepartmentSummary toSummary(Department department);

    DepartmentDetail toDetail(Department department);
}