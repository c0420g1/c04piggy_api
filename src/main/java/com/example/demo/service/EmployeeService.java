package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.model.StockDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends BaseService<Employee> {
    List<EmployeeDTO> search(int pageNumber, int pageSize, String search);
//    List<EmployeeDTO> getAllEmployeeDTO(int pageNumber, String search);
    Optional<EmployeeDTO> getByIdDTO(int id);
}
