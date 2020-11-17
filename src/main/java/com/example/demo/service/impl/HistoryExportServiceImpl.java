package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.*;
import com.example.demo.repository.HistoryExportRepository;
import com.example.demo.service.BaseService;
import com.example.demo.service.CoteService;
import com.example.demo.service.HistoryExportService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class HistoryExportServiceImpl implements HistoryExportService {
    @Autowired
    private JPAStreamer jpaStreamer;
    @Autowired
    private HistoryExportRepository historyExportRepository;
    @Autowired
    private CoteServiceImpl coteService;
    private static List<HistoryExportDTO> exportDTOList;
    private static List<Pig> pigList;
    private static HistoryExportDTO historyExportDTO;

    @Override
    public List<HistoryExportDTO> getAllDTO(int pageNum, String search) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        exportDTOList = new ArrayList<>();
        if (pageNum == -1) {
            jpaStreamer.stream(HistoryExport.class)
                    .filter(
                            e ->
                                    e.getIsDeleted() == 0 && e.getType().equals("cote")
                                            && (e.getCote().getCode().toLowerCase().contains(search.toLowerCase()) ||
                                            e.getEmployee().getName().toLowerCase().contains(search.toLowerCase()) ||
                                            e.getCompany().toLowerCase().contains(search.toLowerCase()) ||
                                            e.getExportDate().toString().contains(search))
                    ).collect(Collectors.toList()).stream()
                    .forEach(

                            g -> {
                                historyExportDTO = HistoryExportDTO.builder()
                                        .id(g.getId())
                                        .coteCode(g.getCote().getCode())
                                        .company(g.getCompany())
                                        .employeeCode(g.getEmployee().getName())
                                        .exportDate(g.getExportDate())
                                        .quantity(g.getQuantity())
                                        .weightTotal(g.getReceivedEmployeeId())
                                        .total(g.getReceivedEmployeeId() * 80000).build();
                                exportDTOList.add(historyExportDTO);
                            }
                    );
            return exportDTOList;
        }
        jpaStreamer.stream(HistoryExport.class)
                .filter(
                        e ->
                                e.getIsDeleted() == 0 && e.getType().equals("cote")
                                        && (e.getCote().getCode().toLowerCase().contains(search.toLowerCase()) ||
                                        e.getEmployee().getName().toLowerCase().contains(search.toLowerCase()) ||
                                        e.getCompany().toLowerCase().contains(search.toLowerCase()) ||
                                        e.getExportDate().toString().contains(search))
                ).collect(Collectors.toList()).stream()
                .skip((pageNum - 1) * pageSize).limit(pageSize)
                .forEach(

                        g -> {
                            historyExportDTO = HistoryExportDTO.builder()
                                    .id(g.getId())
                                    .coteCode(g.getCote().getCode())
                                    .company(g.getCompany())
                                    .employeeCode(g.getEmployee().getName())
                                    .exportDate(g.getExportDate())
                                    .quantity(g.getQuantity())
                                    .weightTotal(g.getReceivedEmployeeId())
                                    .total(g.getReceivedEmployeeId() * 80000).build();
                            exportDTOList.add(historyExportDTO);
                        }
                );
        return exportDTOList;
    }




    @Override
    public List<HistoryExport> getAll() {
        return this.jpaStreamer.stream(HistoryExport.class).collect(Collectors.toList());
    }

    @Override
    public Optional<HistoryExport> getById(int id) {
        return jpaStreamer.stream(HistoryExport.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public int save(HistoryExport historyExport) {
        this.historyExportRepository.save(historyExport);
        return 1;
    }

    @Override
    public int delete(int[] ids) {
        Arrays.stream(ids).forEach(e ->
        {
            HistoryExport a = jpaStreamer.stream(HistoryExport.class).filter(f -> f.getId() == e).findFirst().get();
            a.setIsDeleted(1);
            historyExportRepository.save(a);
        });
        return 1;
    }

    public int exportAllInCote(int idCote, HistoryExport historyExport) {
        //find all pig same id cote
        this.jpaStreamer.stream(Pig.class)
                .filter(h -> h.getIsDeleted() == 0 && h.getCote().getId() == idCote)
                .forEach(
                        g -> {
                            //loop setIsDel  = 1 and set status
                            g.setIsDeleted(1);
                            PigAssociateStatus.builder().pig(g)
                                    .pigStatus(jpaStreamer.stream(PigStatus.class)
                                            .filter(PigStatus$.name.equal("Sold")).findFirst().get());


                        }
                );
        // add to table history export
        historyExportRepository.save(historyExport);
        return 0;
    }

    public int addPigExport(int[] idPigs, HistoryExport historyExport){
        for (int idPig:
                idPigs) {
            jpaStreamer.stream(Pig.class).filter(
                    g-> g.getIsDeleted()==0
            ).forEach(
                    h-> {
                        if (idPig== h.getId()){
                            h.setIsDeleted(1);
                            PigAssociateStatus.builder().pig(h)
                                    .pigStatus(jpaStreamer.stream(PigStatus.class)
                                            .filter(PigStatus$.name.equal("Sold")).findFirst().get());
                        }
                    }
            );
        }
        //add to history export table
        historyExportRepository.save(historyExport);
        return 0;

    }


}
