package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.model.Account$;
import com.example.demo.model.RoleAccount;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleAccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.RoleAccountService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleAccountServiceImpl implements RoleAccountService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    RoleAccountRepository roleAccountRepository;
    @Override
    public List<RoleAccount> getAll() {
        return roleAccountRepository.findAll();
    }

    @Override
    public Optional<RoleAccount> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(RoleAccount roleAccount) {
        try{
            roleAccountRepository.save(roleAccount);
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

    @Override
    public RoleAccount getRoleByIdAccount(int id) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        return jpaStreamer.stream(RoleAccount.class).filter(e->e.getAccount().getId()==id).findFirst().get();
    }
}

