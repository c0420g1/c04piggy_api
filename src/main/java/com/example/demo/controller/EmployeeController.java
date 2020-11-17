package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AccountService accountService;


    @GetMapping("allEmployees")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
   
    // creator: Viet
    //add, update, edit
    @GetMapping("employees/{pageNum}")
    public List<EmployeeDTO> getAllEmployeeDTO(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search){
        try {
            return employeeService.search(pageNum,pageSize, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/employee/{id}")
    public Optional<EmployeeDTO> getDTO(@PathVariable int id){
        try{
            return employeeService.getByIdDTO(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PutMapping("employee")
    public void editEmployee(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping("account")
    public void addAccount(@RequestBody Account account){
        try {
            accountService.save(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("account")
    public void editAccount(@RequestBody Account account){
        try {
            accountService.save(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Hai
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        try{
            employeeList = employeeService.getAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return employeeList;
    }
}
