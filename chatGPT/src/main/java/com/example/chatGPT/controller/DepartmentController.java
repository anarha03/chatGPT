package com.example.chatGPT.controller;

import com.example.chatGPT.dto.create.DepartmentCreateDTO;
import com.example.chatGPT.dto.response.DepartmentResponseDTO;
import com.example.chatGPT.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    public final DepartmentService departmentService;

    @GetMapping
    List<DepartmentResponseDTO> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    DepartmentResponseDTO getById(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    @PostMapping
    public void createDepartment(@RequestBody DepartmentCreateDTO departmentCreateDTO){
        departmentService.createDepartment(departmentCreateDTO);
    }
    @PutMapping("/{id}")
    DepartmentResponseDTO updateById(@PathVariable Integer id,
                                     @RequestBody DepartmentCreateDTO departmentCreateDTO){
        return departmentService.updateDepartment(id,departmentCreateDTO);
    }
}
