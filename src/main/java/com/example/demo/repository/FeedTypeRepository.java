package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FeedType;


public interface FeedTypeRepository extends JpaRepository<FeedType, Integer> {
}
