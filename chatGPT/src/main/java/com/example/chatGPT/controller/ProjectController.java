package com.example.chatGPT.controller;

import com.example.chatGPT.dto.create.EmployeeCreateDTO;
import com.example.chatGPT.dto.create.ProjectCreateDTO;
import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import com.example.chatGPT.dto.response.ProjectResponseDTO;
import com.example.chatGPT.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    ProjectService projectService;

    @GetMapping
    List<ProjectResponseDTO> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    ProjectResponseDTO getById(@PathVariable Integer id) {
        return projectService.getProjectResponse(id);
    }

    @PostMapping
    public void getById(@RequestBody ProjectCreateDTO projectCreateDTO) {
        projectService.createProject(projectCreateDTO);
    }
    @PatchMapping("/{id}")
    public ProjectResponseDTO addEmployee(@PathVariable Integer id,
                                          @RequestParam Integer employeeId){
        return projectService.addEmployeeToProject(id, employeeId);
    }
}
