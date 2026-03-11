package com.example.chatGPT.dto.create;

import com.example.chatGPT.dto.response.ProjectResponseDTO;
import com.example.chatGPT.entity.Department;
import com.example.chatGPT.entity.Project;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreateDTO {

    @NotBlank
    String name;

    String email;

    Double salary;

    Integer departmentId;

    List<ProjectCreateDTO> projects;
}
