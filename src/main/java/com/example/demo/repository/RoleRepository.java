package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.RoleAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
