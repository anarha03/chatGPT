package com.example.chatGPT.controller;

import com.example.chatGPT.dto.create.EmployeeCreateDTO;
import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import com.example.chatGPT.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    EmployeeService employeeService;

    @GetMapping
    List<EmployeeResponseDTO> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    EmployeeResponseDTO getById(@PathVariable Integer id) {
        return employeeService.getEmployeeResponse(id);
    }

    @PostMapping("/create")
    public void getById(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        employeeService.createEmployee(employeeCreateDTO);
    }
}
