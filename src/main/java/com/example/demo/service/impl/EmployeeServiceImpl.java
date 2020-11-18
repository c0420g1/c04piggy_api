package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    AccountRepository accountRepository;

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
    public int save(Employee employee) {
        try{
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(e ->
            {
                Employee a = jpaStreamer.stream(Employee.class).filter(f -> f.getId() == e).findFirst().get();
                Account b = jpaStreamer.stream(Account.class).filter(z -> z.getId()==a.getAccount().getId()).findFirst().get();
                a.setIsDeleted(1);
                b.setIsDeleted(1);
                employeeRepository.save(a);
                accountRepository.save(b);
            });
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<EmployeeDTO> search(int pageNumber, int pageSize, String search) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            if (pageNumber == -1) {
                jpaStreamer.stream(Employee.class).filter(e ->
                        e.getIsDeleted() == 0 &&
                                (e.getAccount().getUsername().contains(search) ||
                                        e.getName().contains(search) || e.getDescription().contains(search)
                                )).sorted(Employee$.id.reversed()).forEach(e -> {
                    RoleAccount rc=  jpaStreamer.stream(RoleAccount.class).filter(r-> r.getAccount().getId()== e.getAccount().getId()).findFirst().get();
                    EmployeeDTO empoyeeDTO = new EmployeeDTO(e.getId(), e.getCode(), e.getAccount().getUsername(), e.getAccount().getPassword(),
                            e.getName(), e.getBirthday(), e.getEmail(), e.getGender(), e.getCardId(),rc.getRole().getName());
                    employeeDTOList.add(empoyeeDTO);
                });
                return employeeDTOList;
            }

            jpaStreamer.stream(Employee.class).filter(e ->
                    e.getIsDeleted() == 0 &&
                            (e.getAccount().getUsername().contains(search) ||
                                    e.getName().contains(search) || e.getDescription().contains(search)
                            )).sorted(Employee$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                RoleAccount rc=  jpaStreamer.stream(RoleAccount.class).filter(r-> r.getAccount().getId()== e.getAccount().getId()).findFirst().get();
                EmployeeDTO empoyeeDTO = new EmployeeDTO(e.getId(), e.getCode(), e.getAccount().getUsername(), e.getAccount().getPassword(),
                        e.getName(), e.getBirthday(), e.getEmail(), e.getGender(), e.getCardId(),rc.getRole().getName());
                employeeDTOList.add(empoyeeDTO);
            });
            return employeeDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jpaStreamer.close();
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

