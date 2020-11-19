package com.example.demo.repository;

import com.example.demo.model.NotificationEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationEmployeeRepository extends JpaRepository<NotificationEmployee, Integer> {
}
