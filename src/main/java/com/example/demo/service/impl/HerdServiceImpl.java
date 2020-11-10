package com.example.demo.service.impl;

import com.example.demo.model.Herd;
import com.example.demo.repository.HerdRepository;
import com.example.demo.service.HerdService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HerdServiceImpl implements HerdService {
    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private HerdRepository herdRepository;

    @Override
    public List<Herd> getAll() {
        List<Herd> herdList;
        herdList = jpaStreamer.stream(Herd.class).collect(Collectors.toList());
        return herdList;
    }

    @Override
    public Optional<Herd> getById(int id) {
        return jpaStreamer.stream(Herd.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(Herd herd) {
        herdRepository.save(herd);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(herdListIdReceive ->
        {
            Herd herdDB = jpaStreamer.stream(Herd.class).filter(f -> f.getId() == herdListIdReceive).findFirst().get();
            herdDB.setIsDeleted(1);
            herdRepository.save(herdDB);
        });
    }
}
