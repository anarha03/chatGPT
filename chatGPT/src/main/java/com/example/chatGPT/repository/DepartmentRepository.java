package com.example.chatGPT.repository;

import com.example.chatGPT.entity.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @EntityGraph(attributePaths = "employees")
    List<Department>findAll();

    void removeById(Integer id);
}
