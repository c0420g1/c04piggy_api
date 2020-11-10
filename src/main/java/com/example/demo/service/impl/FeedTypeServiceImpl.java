package com.example.demo.service.impl;

import com.example.demo.model.FeedType;
import com.example.demo.service.FeedTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedTypeServiceImpl implements FeedTypeService {

    @Override
    public List<FeedType> getAll() {
        return null;
    }

    @Override
    public Optional<FeedType> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(FeedType feedType) {

    }

    @Override
    public void delete(int[] ids) {

    }
}
