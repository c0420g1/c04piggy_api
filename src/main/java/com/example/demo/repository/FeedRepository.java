package com.example.demo.repository;

import com.example.demo.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FeedRepository extends JpaRepository<Feed, Integer> {
}