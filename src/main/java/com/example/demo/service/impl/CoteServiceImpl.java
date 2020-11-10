package com.example.demo.service.impl;

import com.example.demo.model.Cote;
import com.example.demo.model.Cote$;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoteServiceImpl implements CoteService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    CoteRepository coteRepository;


    @Override
    public List<Cote> getAll() {
        List<Cote> coteList;
        coteList = jpaStreamer.stream(Cote.class).collect(Collectors.toList());
        return coteList;
    }


    @Override
    public Optional<Cote> getById(int id) {
//        Cote cote = jpaStreamer.stream(Cote.class).filter(e-> e.getId()==id).findFirst();
        return Optional.empty();
    }

    @Override
    public void save(Cote cote) {

    }

    @Override
    public void delete(int[] ids) {

    }

    @Override
    public List<Cote> search(int pageNum, String search) {
        return null;
    }
}
