package com.example.chatGPT.repository;

import com.example.chatGPT.entity.Employee;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Override
    @NonNull
    @EntityGraph(attributePaths = {"department", "projects"})
    List<Employee> findAll();
}
