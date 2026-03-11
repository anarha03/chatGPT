package com.example.chatGPT.service.implementations;

import com.example.chatGPT.dto.create.EmployeeCreateDTO;
import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import com.example.chatGPT.entity.Department;
import com.example.chatGPT.entity.Employee;
import com.example.chatGPT.exception.EmployeeNotFoundException;
import com.example.chatGPT.mapper.EntityMapper;
import com.example.chatGPT.repository.DepartmentRepository;
import com.example.chatGPT.repository.EmployeeRepository;
import com.example.chatGPT.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EntityMapper entityMapper, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.entityMapper = entityMapper;
        this.departmentRepository = departmentRepository;
    }

    final EmployeeRepository employeeRepository;
    final EntityMapper entityMapper;
    final DepartmentRepository departmentRepository;

    @Override
    public List<EmployeeResponseDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map(emp -> entityMapper.entityToResponse(emp))
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeResponse(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
        return entityMapper.entityToResponse(employee);
    }

    @Override
    public void createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        departmentRepository.findById(employeeCreateDTO.getDepartmentId()).orElseThrow(RuntimeException::new);
        Employee toEntity = entityMapper.createToEntity(employeeCreateDTO);
        employeeRepository.save(toEntity);
    }

    @Override
    @Transactional
    public void updateEmployee(Integer id, EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
        if (!employeeCreateDTO.getName().isEmpty()){
            employee.setName(employeeCreateDTO.getName());
        }
        if (!employeeCreateDTO.getEmail().isEmpty()){
            employee.setEmail(employeeCreateDTO.getEmail());
        }
        if (employeeCreateDTO.getDepartmentId() != null){
            employee.setDepartment(departmentRepository.findById(employeeCreateDTO.getDepartmentId())
                    .orElseThrow(()->new RuntimeException("Department not found")));
        }
        if (employeeCreateDTO.getSalary() != null){
            employee.setSalary(employeeCreateDTO.getSalary());
        }
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
        employeeRepository.deleteById(id);
    }
}
