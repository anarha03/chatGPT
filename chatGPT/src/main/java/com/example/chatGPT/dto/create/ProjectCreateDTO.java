package com.example.chatGPT.dto.create;

import com.example.chatGPT.entity.Employee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectCreateDTO {

    @NotBlank
    String title;

    @NotBlank
    Double budget;

    List<EmployeeCreateDTO> employeeList;
}
