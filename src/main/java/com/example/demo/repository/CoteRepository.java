package com.example.demo.repository;

import com.example.demo.model.Cote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoteRepository extends JpaRepository<Cote, Integer> {
}
