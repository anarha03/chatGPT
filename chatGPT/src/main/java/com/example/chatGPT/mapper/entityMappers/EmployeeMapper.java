package com.example.chatGPT.mapper.entityMappers;

import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import com.example.chatGPT.dto.create.EmployeeCreateDTO;
import com.example.chatGPT.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper  {
    @Mapping(target = "departmentId",source = "department.id")
    EmployeeResponseDTO entityToResponse(Employee employee);

    @Mapping(source = "departmentId",target = "department.id")
    Employee responseToEntity(EmployeeResponseDTO employeeResponseDTO);

    @Mapping(target = "departmentId",source = "department.id")
    EmployeeCreateDTO entityToCreate(Employee employee);
    @Mapping(target = "department.id",source = "departmentId")
    Employee createToEntity(EmployeeCreateDTO employeeCreateDTO);

    List<Employee> createListToEntityList(List <EmployeeCreateDTO> list);
}
