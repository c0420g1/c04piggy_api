package com.example.demo.service.impl;

import com.example.demo.model.FeedType;
import com.example.demo.service.FeedTypeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedTypeServiceImpl implements FeedTypeService {
    @Autowired
    JPAStreamer jpaStreamer;

    @Override
    public List<FeedType> getAll() {
        List<FeedType> feedTypeList;
        try {
            feedTypeList = jpaStreamer.stream(FeedType.class).collect(Collectors.toList());
            return feedTypeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
