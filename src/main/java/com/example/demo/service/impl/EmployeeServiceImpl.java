package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList;
        employeeList = jpaStreamer.stream(Employee.class).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Optional<Employee> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {
        try{
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int[] ids) {

    }


    @Override
    public List<EmployeeDTO> getAllEmployeeDTO(int pageNumber, String search) {

        List<EmployeeDTO> res = new ArrayList<>();

        try {
            jpaStreamer.stream(Employee.class).filter(e -> e.getName().contains(search))
                    .skip((pageNumber-1)*pageSize)
                    .limit(pageSize).forEach(e->{
                  RoleAccount rc=  jpaStreamer.stream(RoleAccount.class).filter(r-> r.getAccount().getId()== e.getAccount().getId()).findFirst().get();
                EmployeeDTO employeeDTO = new EmployeeDTO(e.getAccount().getId(),e.getCode(),e.getAccount().getUsername(),
                        e.getAccount().getPassword(),e.getName(),e.getBirthday(),e.getEmail(),e.getGender(),e.getCardId(),rc.getRole().getName());
                res.add(employeeDTO);
            });
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }

    @Override
    public Optional<EmployeeDTO> getByIdDTO(int id) {
        Employee emp;
        EmployeeDTO res;
        RoleAccount rc;
        try{
             emp = jpaStreamer.stream(Employee.class).filter(Employee$.id.equal(id)).findFirst().get();
             rc=  jpaStreamer.stream(RoleAccount.class).filter(r-> r.getAccount().getId()== emp.getAccount().getId()).findFirst().get();
             res=  EmployeeDTO.builder().id(emp.getId()).code(emp.getCode()).username(emp.getAccount().getUsername())
                    .password(emp.getAccount().getPassword()).name(emp.getName()).birthday(emp.getBirthday())
                    .email(emp.getEmail()).gender(emp.getGender()).cardId(emp.getCardId()).nameRole(rc.getRole().getName()).build();
            return Optional.of(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

