package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AccountService;
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
public class AccountServiceImpl implements AccountService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Optional<Account> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Account account) {
        try{
            accountRepository.save(account);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(int[] ids) {
        return 0;
    }
}

