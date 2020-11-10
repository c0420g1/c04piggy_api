package com.example.demo.service.impl;

import com.example.demo.service.FeedTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedTypeServiceImpl implements FeedTypeService {
    @Override
    public List<FeedTypeService> getAll() {
        return null;
    }

    @Override
    public Optional<FeedTypeService> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(FeedTypeService feedTypeService) {

    }

    @Override
    public void delete(int[] ids) {

    }

    @Override
    public List<FeedTypeService> search(int pageNum, String search) {
        return null;
    }
}
