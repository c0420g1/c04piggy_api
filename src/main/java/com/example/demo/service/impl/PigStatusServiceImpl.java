package com.example.demo.service.impl;

import com.example.demo.model.PigStatus;
import com.example.demo.service.PigStatusService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PigStatusServiceImpl implements PigStatusService {
    @Autowired
    private JPAStreamer jpaStreamer;

    @Override
    public List<PigStatus> getAll() {
        return jpaStreamer.stream(PigStatus.class).collect(Collectors.toList());
    }

    @Override
    public Optional<PigStatus> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(PigStatus pigStatus) {
        return 0;
    }

    @Override
    public int delete(int[] ids) {
        return 0;
    }
}
