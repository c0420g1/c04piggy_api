package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends BaseService<Employee> {
    List<EmployeeDTO> getAllEmployeeDTO(int pageNumber, String search);
    Optional<EmployeeDTO> getByIdDTO(int id);
}
