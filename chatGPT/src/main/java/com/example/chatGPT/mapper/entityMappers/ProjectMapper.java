package com.example.chatGPT.mapper.entityMappers;

import com.example.chatGPT.dto.create.ProjectCreateDTO;
import com.example.chatGPT.dto.response.ProjectResponseDTO;
import com.example.chatGPT.entity.Project;
import com.example.chatGPT.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "employeeNamesList",
            expression = "java(project.getEmployeeList().stream().map(Employee::getName).collect(java.util.stream.Collectors.toList()))")
    ProjectResponseDTO entityToResponse(Project project);

    Project responseToEntity(ProjectResponseDTO projectResponseDTO);

    ProjectCreateDTO entityToCreate(Project project);

    Project createToEntity(ProjectCreateDTO projectCreateDTO);

}

