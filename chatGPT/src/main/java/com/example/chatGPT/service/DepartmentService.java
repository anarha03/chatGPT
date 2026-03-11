package com.example.chatGPT.service;

import com.example.chatGPT.dto.create.DepartmentCreateDTO;
import com.example.chatGPT.dto.response.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAll();
    DepartmentResponseDTO getDepartment(Integer id);
    void createDepartment(DepartmentCreateDTO departmentCreateDTO);
    DepartmentResponseDTO updateDepartment(Integer id, DepartmentCreateDTO departmentCreateDTO);
    void deleteDepartmentById(Integer id);
}
