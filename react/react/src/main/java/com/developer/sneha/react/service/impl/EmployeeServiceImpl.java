package com.developer.sneha.react.service.impl;

import com.developer.sneha.react.dto.EmployeeDto;
import com.developer.sneha.react.entity.Employee;
import com.developer.sneha.react.exception.ResourseNotFoundException;
import com.developer.sneha.react.mapper.EmployeeMapper;
import com.developer.sneha.react.repository.EmployeeRepository;
import com.developer.sneha.react.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourseNotFoundException("Employee  is not exists with given id :"+ employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
          List<Employee> employees = employeeRepository.findAll();
          return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee))
                  .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourseNotFoundException("Employee is not exists with given id: " + employeeId));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());

        Employee updatedEmployeeobj = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updatedEmployeeobj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourseNotFoundException("Employee is not exists with given id: " + employeeId));
        employeeRepository.deleteById(employeeId);

    }
}
