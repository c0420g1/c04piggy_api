package com.example.demo.service.impl;

import com.example.demo.common.SameParentException;
import com.example.demo.model.*;
import com.example.demo.repository.PigAssociateStatusRepository;
import com.example.demo.repository.PigRepository;
import com.example.demo.service.HistoryExportService;
import com.example.demo.service.PigService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class PigServiceImpl implements PigService {

    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private PigRepository pigRepository;

    @Autowired
    private HistoryExportService historyExportService;

    @Autowired
    private PigAssociateStatusRepository pigAssociateStatusRepository;


    //CRUD
    @Override
    public List<Pig> getAll() {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");

        List<Pig> pigList;
            pigList = jpaStreamer.stream(Pig.class).collect(Collectors.toList());
            return pigList;
    }

    @Override
    public List<PigDTO> listPigSearch(int pageNumber, String search) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");

        List<PigDTO> pigList = new ArrayList<>();
        try{
            if(pageNumber==-1){
                jpaStreamer.stream(Pig.class)
                        //list pig for show at start
                        .filter(e -> (e.getCode().toLowerCase().contains(search) || e.getCote().getCode().toLowerCase().contains(search) ||
                                e.getHerd().getName().toLowerCase().contains(search)) && e.getIsDeleted() ==0)
                        .forEach(p -> {
                            //filter into list entity pig for show
                            PigDTO pigDTO = new PigDTO(p.getId(), p.getCode(), p.getCote().getCode(), p.getImportDate(), p.getPigAssociateStatuses().stream().filter(f -> f.getPig().getId() == p.getId()).collect(Collectors.toList()), p.getWeight());
                            pigList.add(pigDTO);
                        });
            }else {
                jpaStreamer.stream(Pig.class).filter(e -> (e.getCode().toLowerCase().contains(search) || e.getCote().getCode().toLowerCase().contains(search) ||
                                e.getHerd().getName().toLowerCase().contains(search)) && e.getIsDeleted() == 0)
                        //begin pagenation
                        .collect(Collectors.toList()).stream().skip((pageNumber - 1) * pageSize).limit(pageSize).forEach(p -> {
                    PigDTO pigDTO = new PigDTO(p.getId(), p.getCode(), p.getCote().getCode(), p.getImportDate(), p.getPigAssociateStatuses().stream().filter(f -> f.getPig().getId() == p.getId()).collect(Collectors.toList()), p.getWeight());
                    pigList.add(pigDTO);
                });
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return pigList;
    }

    @Override
    public Optional<Pig> getById(int id) {
        return jpaStreamer.stream(Pig.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public int save(Pig pig) {
        pigRepository.save(pig);
        return 1;
    }

    @Override
    public int delete(int[] ids) {
        Arrays.stream(ids).forEach(pigListIdReceive ->
        {
            Pig pigDB = jpaStreamer.stream(Pig.class).filter(f -> f.getId() == pigListIdReceive).findFirst().get();
            pigDB.setIsDeleted(1);
            pigRepository.save(pigDB);
        });
        return 0;
    }

    //match pigs to breed new pig function

    public List<Pig> pickFemalePig(String filter) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");

        List<Pig> pigList = new ArrayList<>();
        long count;
        pigList = jpaStreamer.stream(Pig.class).filter(e -> (e.getGender() == 0) && (e.getIsDeleted() == 0)).collect(Collectors.toList());
        if ("female".equals(filter)) {
            for (int i = 0; i <= pigList.size(); i++) {
                count = jpaStreamer.stream(Pig.class)
                        .filter(Pig$.motherId.equal(pigList.get(i).getId()))
                        .count();
                if (count >= 5) {
                    pigList.remove(pigList.get(i));
                }
            }
        }
        return pigList;
    }

    public List<Pig> pickMalePig(String filter) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<Pig> pigList = new ArrayList<>();
        double totalWeight = 0;
        List<Pig> checkWeight = new ArrayList<>();
        pigList = jpaStreamer.stream(Pig.class).filter(e -> (e.getGender() == 1) && (e.getIsDeleted() == 0)).collect(Collectors.toList());
        if ("male".equals(filter)) {
            for (int i = 0; i <= pigList.size(); i++) {
                checkWeight = (jpaStreamer.stream(Pig.class)
                        .filter(Pig$.fatherId.equal(pigList.get(i).getId())).collect(Collectors.toList()));
            }
            pigList.removeAll(pigList);
            for (int e = 0 ; e <= checkWeight.size() ; e ++){
                totalWeight += checkWeight.get(e).getWeight();
                if (checkWeight.size() > 0 && (totalWeight / checkWeight.size()) >= 100 ){
                    pigList.add(checkWeight.get(e));
                }
            }
        }
        return pigList;
    }

    @Override
    public void saveNewPig(Pig pig){
        Optional<Pig> fatherPig;
        Optional<Pig> motherPig;
        fatherPig = jpaStreamer.stream(Pig.class).filter(Pig$.id.equal(pig.getFatherId())).findFirst();
        motherPig = jpaStreamer.stream(Pig.class).filter(Pig$.id.equal(pig.getMotherId())).findFirst();
        if (fatherPig.get().getFatherId().equals(motherPig.get().getFatherId())
                && fatherPig.get().getMotherId().equals(motherPig.get().getMotherId())){
            throw new SameParentException("2 con định chọn có cùng bố mẹ");
        } else {
            pigRepository.save(pig);
        }
    }

    @Override
    public void soldPig(int id) {
        Pig pig = pigRepository.getOne(id);
        PigAssociateStatus pigAssociateStatus = new PigAssociateStatus();
        pigAssociateStatus.setPig(pig);
        pigAssociateStatus.setPigStatus(jpaStreamer.stream(PigStatus.class).filter(PigStatus$.name.equal("Sold")).findFirst().get());
        pig.setIsDeleted(1);
        pigRepository.save(pig);
        pigAssociateStatusRepository.save(pigAssociateStatus);

        
        Pig tempPig = jpaStreamer.stream(Pig.class).filter(e -> e.getId() == id).findFirst().get();
        HistoryExport hi = new HistoryExport();
        hi.setCote(tempPig.getCote());
        hi.setEmployee(tempPig.getCote().getEmployee());
        hi.setExportDate(LocalDate.now());
        //

        historyExportService.save(hi);
    }


}
