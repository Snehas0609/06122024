package com.developer.sneha.react.mapper;

import com.developer.sneha.react.dto.EmployeeDto;
import com.developer.sneha.react.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartment()


        );
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto) {

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getSalary(),
                employeeDto.getDepartment()

        );

    }
}
