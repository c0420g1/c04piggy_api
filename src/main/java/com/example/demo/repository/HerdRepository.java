package com.example.demo.repository;

import com.example.demo.model.Herd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerdRepository extends JpaRepository<Herd,Integer> {
}
