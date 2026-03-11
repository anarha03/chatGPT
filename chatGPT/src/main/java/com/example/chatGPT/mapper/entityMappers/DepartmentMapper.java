package com.example.chatGPT.mapper.entityMappers;

import com.example.chatGPT.dto.create.DepartmentCreateDTO;
import com.example.chatGPT.dto.response.DepartmentResponseDTO;
import com.example.chatGPT.entity.Department;
import com.example.chatGPT.mapper.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring"/*, uses = EmployeeMapper.class*/)
public interface DepartmentMapper  {

    DepartmentResponseDTO entityToResponse(Department department);

    Department responseToEntity(DepartmentResponseDTO departmentResponseDTO);

    DepartmentCreateDTO entityToCreate(Department department);

    Department createToEntity(DepartmentCreateDTO departmentCreateDTO);

}
