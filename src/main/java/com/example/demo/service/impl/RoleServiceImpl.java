package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.RoleAccount;
import com.example.demo.repository.RoleAccountRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleAccountService;
import com.example.demo.service.RoleService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Role role) {
        try{
            roleRepository.save(role);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int[] ids) {
        return 1;
    }

}

