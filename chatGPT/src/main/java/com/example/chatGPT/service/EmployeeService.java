package com.example.chatGPT.service;

import com.example.chatGPT.dto.create.EmployeeCreateDTO;
import com.example.chatGPT.dto.create.ProjectCreateDTO;
import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import com.example.chatGPT.dto.response.ProjectResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getAll();
    EmployeeResponseDTO getEmployeeResponse(Integer id);
    void createEmployee(EmployeeCreateDTO employeeCreateDTO);
    void updateEmployee(Integer id, EmployeeCreateDTO employeeCreateDTO);
    void deleteEmployeeById(Integer id);
}
