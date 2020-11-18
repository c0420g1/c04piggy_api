package com.example.demo.controller;
import com.example.demo.model.*;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.RoleAccountService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleAccountService roleAccountService;


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
    @GetMapping("role")
    public List<Role> getRole(){
        return roleService.getAll();
    }
    @GetMapping("/employe/{id}")
    public String getDTO(@PathVariable int id){
        try{
            return "r";
//            return employeeService.getByIdDTO(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping("employee")
    public int addEmployee(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    @PostMapping("account")
    public void addAccount(@RequestBody Account account){
        try {
            accountService.save(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("getRole/{id}")
    public RoleAccount getRole(@PathVariable int id){
        try {
           return roleAccountService.getRoleByIdAccount(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping("roleaccount")
    public void addRoleAccount(@RequestBody RoleAccount roleAccount){
        try {
            roleAccountService.save(roleAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("findlast")
    public Account find(){
        return accountService.findLast();
    }

    @PutMapping("deleteEmployee")
    public int deleteEm(@RequestBody int[] ids){
        try {
           employeeService.delete(ids);
           return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
