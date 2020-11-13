package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.*;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;
import com.example.demo.service.HistoryExportService;
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
        coteList = jpaStreamer.stream(Cote.class).sorted(Cote$.importDate.reversed().thenComparing(Cote$.exportDate)).collect(Collectors.toList());
        return coteList;
    }


    @Override
    public Optional<Cote> getById(int id) {
        return jpaStreamer.stream(Cote.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public int save(Cote cote) {

        try{
            coteRepository.save(cote);
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(e ->
            {
                Cote cote = jpaStreamer.stream(Cote.class).filter(f -> f.getId() == e).findFirst().get();
                cote.setIsDeleted(1);
                coteRepository.save(cote);

            });
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }


//    // a.quoc
//    @Override
//    public List<CoteDTO> search(int pageNumber, String search) {
//        List<CoteDTO> res = new ArrayList<>();
//        jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search) ||
//                e.getHerd().getName().contains(search)).sorted(Cote$.id.reversed()).skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
//            CoteDTO coteDTO = new CoteDTO(e.getId(),e.getCode(), e.getQuantity(), e.getHerd().getName(), e.getEmployee().getName(), e.getImportDate().toString(), e.getExportDate().toString());
//            res.add(coteDTO);
//        });
//        return res;
//    }


    //hai
    @Override
    public List<CoteDTO> searchCote(int pageNum, String search){
        List<CoteDTO> coteList = new ArrayList<>();
        String temp ="";
        if (temp.equals(search)){
           jpaStreamer.stream(Cote.class).skip((pageNum - 1) * pageSize).limit(pageSize)
                    .sorted(Cote$.id.reversed())
                    .collect(Collectors.toList())
                    .forEach(cote ->{
                        // Tim ra so luong heo co cung herd => quantity;
                        List<Pig> pigList = new ArrayList<>();
                        pigList = jpaStreamer.stream(Pig.class).filter(pig -> (pig.getHerd().getName().contains(cote.getHerd().getName()) && pig.getIsDeleted() ==0)).collect(Collectors.toList());
                        int quantity = pigList.size();
                        String exportDate= "";
                        if(cote.getExportDate() != null){
                            exportDate = cote.getExportDate().toString();
                        }

                        CoteDTO coteDTO = CoteDTO.builder()
                                .id(cote.getId())
                                .coteCode(cote.getCode())
                                .herdName(cote.getHerd().getName())
                                .employeeName(cote.getEmployee().getName())
                                .importDate(cote.getImportDate().toString())
                                .exportDate(exportDate)
                                .quantity(quantity).build();
                        coteList.add(coteDTO);
                    });
        } else{
            jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search)
                    || e.getHerd().getName().contains(search)
                    || e.getCode().contains(search))
                    .sorted(Cote$.id.reversed())
                    .skip((pageNum - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList())
                    .forEach(cote -> {
                        // Tim ra so luong heo co cung herd => quantity;
                        List<Pig> pigList = new ArrayList<>();
                        pigList = jpaStreamer.stream(Pig.class).filter(pig -> (pig.getHerd().getName().contains(cote.getHerd().getName()) && pig.getIsDeleted() ==0)).collect(Collectors.toList());
                        int quantity = pigList.size();
                        String exportDate= "";
                        if(cote.getExportDate() != null){
                            exportDate = cote.getExportDate().toString();
                        }
                        CoteDTO coteDTO = CoteDTO.builder()
                                .id(cote.getId())
                                .coteCode(cote.getCode())
                                .herdName(cote.getHerd().getName())
                                .employeeName(cote.getEmployee().getName())
                                .importDate(cote.getImportDate().toString())
                                .exportDate(exportDate)
                                .quantity(quantity).build();
                        coteList.add(coteDTO);
                    });
        }

        return coteList;
    }

    @Override
    public List<Cote> searchCoteNoPagination(String search) {
        List<Cote> coteList;
        String temp ="";
        if (temp.equals(search)){
            coteList = jpaStreamer.stream(Cote.class)
                    .sorted(Cote$.id.reversed())
                    .collect(Collectors.toList());
        } else{
            coteList = jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search)
                    || e.getHerd().getName().contains(search)
                    || e.getCode().contains(search)
                    || e.getImportDate().toString().contains(search)).sorted(Cote$.id.reversed())
                    .collect(Collectors.toList());
        }

        return coteList;
    }

    @Override
    public List<Pig> getAllPig(String herdCode) {
        List<Pig> pigList;
        pigList = jpaStreamer.stream(Pig.class).filter(e -> e.getHerd().getName().contains(herdCode)).collect(Collectors.toList());
        for (int i =0; i< pigList.size();i++) {
            pigList.get(i).getWeight();
        }
        return pigList;
    }

}
