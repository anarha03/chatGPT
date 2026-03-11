package com.example.chatGPT.service.implementations;

import com.example.chatGPT.dto.create.ProjectCreateDTO;
import com.example.chatGPT.dto.response.ProjectResponseDTO;
import com.example.chatGPT.entity.Employee;
import com.example.chatGPT.entity.Project;
import com.example.chatGPT.mapper.EntityMapper;
import com.example.chatGPT.repository.EmployeeRepository;
import com.example.chatGPT.repository.ProjectRepository;
import com.example.chatGPT.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    public ProjectServiceImpl(EmployeeRepository employeeRepository, ProjectRepository projectRepository, EntityMapper entityMapper) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.entityMapper = entityMapper;
    }

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EntityMapper entityMapper;

    @Override
    public List<ProjectResponseDTO> getAll() {
        return projectRepository.findAll().stream()
                .map(entityMapper::entityToResponse)
                .toList();
    }

    @Override
    public ProjectResponseDTO getProjectResponse(Integer id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return entityMapper.entityToResponse(project);
    }

    @Override
    public void createProject(ProjectCreateDTO projectCreateDTO) {
        Project toEntity = entityMapper.createToEntity(projectCreateDTO);
        projectRepository.save(toEntity);
    }

    @Override
    public void updateProject(Integer id, ProjectCreateDTO projectCreateDTO) {
        Project project = projectRepository.findById(id).orElseThrow(RuntimeException::new);
        if (!projectCreateDTO.getTitle().isEmpty()){
            project.setTitle(projectCreateDTO.getTitle());
        }
        if (projectCreateDTO.getBudget() !=null){
            project.setBudget(projectCreateDTO.getBudget());
        }
        projectRepository.save(project);

    }

    @Override
    public void deleteProjectById(Integer id) {
        projectRepository.findById(id).orElseThrow(RuntimeException::new);
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponseDTO addEmployeeToProject(Integer id, Integer employeeId) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("No any project fro this id"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("No any Employee from this id."));
        project.getEmployeeList().add(employee);
        employee.getProjects().add(project);
        projectRepository.save(project);
        employeeRepository.save(employee);
        return entityMapper.entityToResponse(project);
    }
}
