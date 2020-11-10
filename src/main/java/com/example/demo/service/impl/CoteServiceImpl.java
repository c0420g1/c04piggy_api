package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import static com.example.demo.common.StringUtil.pageSize;

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
        return jpaStreamer.stream(Cote.class).filter(e-> e.getId()==id).findFirst();
    }

    @Override
    public void save(Cote cote) {
        coteRepository.save(cote);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(e-> coteRepository.deleteById(e));
    }

    @Override
    public List<CoteDTO> search(int pageNumber, String search) {
        List<CoteDTO> res= new ArrayList<>();
        jpaStreamer.stream(Cote.class).filter(e-> e.getEmployee().getName().contains(search) ||
                e.getHerd().getName().contains(search)).skip(pageNumber).limit(pageSize).forEach(e->{
            CoteDTO coteDTO= new CoteDTO(e.getId(), e.getQuantity(), e.getHerd().getName(), e.getEmployee().getName());
            res.add(coteDTO);
        });

        return res;
    }
}
