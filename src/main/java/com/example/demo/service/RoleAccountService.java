package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.RoleAccount;

public interface RoleAccountService extends BaseService<RoleAccount> {
    RoleAccount getRoleByIdAccount(int id);
}
