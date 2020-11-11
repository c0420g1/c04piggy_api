package com.example.demo.service.impl;

import com.example.demo.model.Pig;
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
    private static final Log errorLog = LogFactory.getLog(PigServiceImpl.class);;

    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private PigRepository pigRepository;

    @Override
    public List<Pig> getAll() {
        List<Pig> pigList;
        try {
            pigList = jpaStreamer.stream(Pig.class).collect(Collectors.toList());
            return pigList;
        }catch (Exception e){
            errorLog.error("lỗi tại vị trí getAll-pigList");
            e.getMessage();
            return pigList = null;
        }
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
}
