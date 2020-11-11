package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.model.FeedType;
import com.example.demo.service.FeedTypeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedTypeServiceImpl implements FeedTypeService {

    @Autowired
    private JPAStreamer jpaStreamer;

    //Thịnh
    // trả về list Feedtype
    @Override
    public List<FeedType> getAll() {
        try {
            List<FeedType> feedList;
            feedList = jpaStreamer.stream(FeedType.class).collect(Collectors.toList());
            return feedList;
        } catch (Exception e) {
            System.out.println(e);
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
