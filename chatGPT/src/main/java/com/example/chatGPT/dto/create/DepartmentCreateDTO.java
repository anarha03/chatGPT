package com.example.chatGPT.dto.create;

import com.example.chatGPT.dto.response.EmployeeResponseDTO;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateDTO {
    @NotBlank
    String name;
    @NotBlank
    String location;

}
