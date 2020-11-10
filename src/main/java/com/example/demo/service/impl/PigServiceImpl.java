package com.example.demo.service.impl;

import com.example.demo.model.Pig;
import com.example.demo.repository.PigRepository;
import com.example.demo.service.PigService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PigServiceImpl implements PigService {
    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private PigRepository pigRepository;

    @Override
    public List<Pig> getAll() {
        List<Pig> pigList;
        pigList = jpaStreamer.stream(Pig.class).collect(Collectors.toList());
        return pigList;
    }

    @Override
    public Optional<Pig> getById(int id) {
        return jpaStreamer.stream(Pig.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(Pig pig) {
        pigRepository.save(pig);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(pigListIdReceive ->
        {
            Pig pigDB = jpaStreamer.stream(Pig.class).filter(f -> f.getId() == pigListIdReceive).findFirst().get();
            pigDB.setIsDeleted(1);
            pigRepository.save(pigDB);
        });
    }
}
