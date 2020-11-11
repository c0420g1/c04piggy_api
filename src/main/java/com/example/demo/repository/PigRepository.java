package com.example.demo.repository;

import com.example.demo.model.Pig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PigRepository extends JpaRepository<Pig,Integer> {
}
