package com.example.demo.service;

import com.example.demo.model.Cote;
import com.example.demo.model.Cote$;
import com.example.demo.repository.CoteRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CoteServiceImpl implements CoteService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    CoteRepository coteRepository;

    @Override
    public List<Cote> getAll(int pageNum, String search) {
        int pageSize =10;
        String tempTest = "";
        List<Cote> coteList = new ArrayList<>();
        if (tempTest.equals(search)) {
         coteList = jpaStreamer.stream(Cote.class)
                    .skip((pageNum - 1) * pageSize).limit(pageSize)
                    .filter( Cote$.code.contains(search))
                    .collect(Collectors.toList());
        } else {
          coteList =  jpaStreamer.stream(Cote.class)
                    .filter( Cote$.code.contains(search))
                    .skip((pageNum - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
        }
        return coteList;
    }

    @Override
    public void save(Cote cote) {
        coteRepository.save(cote);
    }

    @Override
    public Cote findById(int id) {
        Cote cote;
        cote = coteRepository.findById(id).orElse(null);
        return cote;
    }

    @Override
    public void deleteById(int id){
      coteRepository.deleteById(id);
    }

}
