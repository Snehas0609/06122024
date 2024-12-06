package com.developer.sneha.react.repository;

import com.developer.sneha.react.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
