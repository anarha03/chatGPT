package com.example.chatGPT.service;

import com.example.chatGPT.dto.create.ProjectCreateDTO;
import com.example.chatGPT.dto.response.ProjectResponseDTO;
import com.example.chatGPT.entity.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseDTO>getAll();
    ProjectResponseDTO getProjectResponse(Integer id);
    void createProject(ProjectCreateDTO projectCreateDTO);
    void updateProject(Integer id, ProjectCreateDTO projectCreateDTO);
    void deleteProjectById(Integer id);

    ProjectResponseDTO addEmployeeToProject(Integer id, Integer employeeId);
}
