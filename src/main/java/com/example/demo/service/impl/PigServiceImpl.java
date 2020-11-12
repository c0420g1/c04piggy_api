package com.example.demo.service.impl;

import com.example.demo.model.Pig;
import com.example.demo.model.Pig$;
import com.example.demo.model.PigDTO;
import com.example.demo.repository.PigRepository;
import com.example.demo.service.PigService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class PigServiceImpl implements PigService {

    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private PigRepository pigRepository;

    //CRUD
    @Override
    public List<Pig> getAll() {
        List<Pig> pigList;
            pigList = jpaStreamer.stream(Pig.class).collect(Collectors.toList());
            return pigList;
    }

    @Override
    public List<PigDTO> listPigSearch(int pageNumber, String search) {
        List<PigDTO> pigList = new ArrayList<>();
        jpaStreamer.stream(Pig.class).filter(e -> e.getCode().contains(search) || e.getCote().getCode().contains(search) ||
                e.getHerd().getName().contains(search)).skip(pageNumber).limit(pageSize).forEach(e -> {
            PigDTO pigDTO = new PigDTO(e.getId(), e.getCote().getCode(), e.getImportDate(), e.getPigAssociateStatuses().stream().collect(Collectors.toList()), e.getWeight());
            pigList.add(pigDTO);
                });
        return pigList;
    }

    @Override
    public Optional<Pig> getById(int id) {
        return jpaStreamer.stream(Pig.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public int save(Pig pig)
    {
        try {
            pigRepository.save(pig);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(pigListIdReceive ->
            {
                Pig pigDB = jpaStreamer.stream(Pig.class).filter(f -> f.getId() == pigListIdReceive).findFirst().get();
                pigDB.setIsDeleted(1);
                pigRepository.save(pigDB);
            });
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    //match pigs to breed new pig function

    public List<Pig> pickFemalePig() {
        List<Pig> pigList = new ArrayList<>();
        pigList = jpaStreamer.stream(Pig.class).filter(Pig$.gender.equal((byte) 0)).collect(Collectors.toList());
        for (int i = 0; i< pigList.size(); i++){
            long count = jpaStreamer.stream(Pig.class)
                    .filter(Pig$.motherId.equal(pigList.get(i).getId()))
                    .count();
            if (count >= 5){
                pigList.remove(pigList.get(i));
            }
        }
        return pigList;
    }
}
