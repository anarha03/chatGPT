package com.example.chatGPT.dto.response;

import com.example.chatGPT.entity.Department;
import com.example.chatGPT.entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponseDTO {
    Integer id;

    String name;

    String email;

    @JsonIgnore
    Double salary;

    Integer departmentId;

    List<ProjectResponseDTO> projects;
}
