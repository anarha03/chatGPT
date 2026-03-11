package com.example.chatGPT.service.implementations;

import com.example.chatGPT.dto.create.DepartmentCreateDTO;
import com.example.chatGPT.dto.response.DepartmentResponseDTO;
import com.example.chatGPT.entity.Department;
import com.example.chatGPT.mapper.EntityMapper;
import com.example.chatGPT.repository.DepartmentRepository;
import com.example.chatGPT.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EntityMapper entityMapper) {
        this.departmentRepository = departmentRepository;
        this.entityMapper = entityMapper;
    }

    DepartmentRepository departmentRepository;
    EntityMapper entityMapper;

    @Override
    public List<DepartmentResponseDTO> getAll() {
        return departmentRepository.findAll().stream()
                .map(dp -> entityMapper.entityToResponse(dp))
                .toList();
    }

    @Override
    public DepartmentResponseDTO getDepartment(Integer id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return entityMapper.entityToResponse(department);
    }

    @Transactional
    @Override
    public void createDepartment(DepartmentCreateDTO departmentCreateDTO) {
        Department toEntity = entityMapper.createToEntity(departmentCreateDTO);
        departmentRepository.save(toEntity);
    }

    @Transactional
    @Override
    public DepartmentResponseDTO updateDepartment(Integer id, DepartmentCreateDTO departmentCreateDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Update ucun %s id-li department tapilmadi", id)));
        if (!departmentCreateDTO.getName().isEmpty()) {
            department.setName(departmentCreateDTO.getName());
        }
        if (!departmentCreateDTO.getLocation().isEmpty()) {
            department.setLocation(departmentCreateDTO.getLocation());
        }
        departmentRepository.save(department);
        return entityMapper.entityToResponse(department);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("%s id-li Department tapilmadi.", id)));
    }
}
