package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

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
        return jpaStreamer.stream(Cote.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(Cote cote) {
        coteRepository.save(cote);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(e ->
        {
            Cote a = jpaStreamer.stream(Cote.class).filter(f -> f.getId() == e).findFirst().get();
            a.setIsDeleted(1);
            coteRepository.save(a);
        });
    }


    // a.quoc
    @Override
    public List<CoteDTO> search(int pageNumber, String search) {
        List<CoteDTO> res = new ArrayList<>();
        jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search) ||
                e.getHerd().getName().contains(search)).skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
            CoteDTO coteDTO = new CoteDTO(e.getId(), e.getQuantity(), e.getHerd().getName(), e.getEmployee().getName());
            res.add(coteDTO);
        });
        return res;
    }


    //hai
    @Override
    public List<Cote> searchCote(int pageNum, String search){
        List<Cote> coteList;
        String temp ="";
        if (temp.equals(search)){
            coteList = jpaStreamer.stream(Cote.class).skip((pageNum - 1) * pageSize).limit(pageSize)
                    .filter(e -> e.getEmployee().getName().contains(search)
                    || e.getHerd().getName().contains(search)
                    || e.getCode().contains(search)
                    || e.getExportDate().toString().contains(search))
                    .collect(Collectors.toList());
        } else{
            coteList = jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search)
                    || e.getHerd().getName().contains(search)
                    || e.getCode().contains(search)
                    || e.getExportDate().toString().contains(search)).skip((pageNum - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
        }

        return coteList;
    }

    @Override
    public List<Pig> getAllPig(String herdCode) {
        List<Pig> pigList;
        pigList = jpaStreamer.stream(Pig.class).filter(e -> e.getHerd().getName().equals(herdCode)).collect(Collectors.toList());
        return pigList;
    }
}
