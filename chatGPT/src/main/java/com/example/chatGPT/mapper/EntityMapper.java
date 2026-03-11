package com.example.chatGPT.mapper;

import com.example.chatGPT.mapper.entityMappers.DepartmentMapper;
import com.example.chatGPT.mapper.entityMappers.EmployeeMapper;
import com.example.chatGPT.mapper.entityMappers.ProjectMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper extends DepartmentMapper, EmployeeMapper, ProjectMapper {
}
