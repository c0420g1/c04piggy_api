package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int[] ids) {
        return 1;
    }
}

