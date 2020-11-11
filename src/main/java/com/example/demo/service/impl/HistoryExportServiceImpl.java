package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.Cote;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.Pig;
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

    @Override
    public List<HistoryExportDTO> search(int pageNum, String search) {
        List<HistoryExportDTO> exportList = new ArrayList<>();
        try {
            jpaStreamer.stream(HistoryExport.class)
                    .skip((pageNum - 1) * pageSize).limit(pageSize)
                    .filter(
                            e ->
                                    e.getIsDeleted() == 0 && (
                                            search.equals(e.getCompany()) ||
                                            search.equals(e.getEmployee().getCode()) ||
                                            search.contains(e.getCote().getCode())
                                            ||
                                            e.getExportDate().toString().contains(search))
                    ).forEach(g -> {
                        List<Pig> pigList = coteService.getAllPig(g.getCote().getHerd().getName());
                        int weight =0;
                        for (int i =0; i< pigList.size(); i++){
                            weight += pigList.get(i).getWeight();
                        }
                        HistoryExportDTO h = HistoryExportDTO.builder()
                                .id(g.getId())
                                .coteCode(g.getCote().getCode())
                                .company(g.getCompany())
                                .employeeCode(g.getEmployee().getName())
                                .exportDate(g.getExportDate())
                                .quantity(pigList.size())
                                .weightTotal(weight)
                                .total(weight * 80000).build();
                        exportList.add(h);
                   });
            System.out.println("Have "+ exportList.size()+ " pig found");
        } catch (
                Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return exportList;
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
    public void save(HistoryExport historyExport) {
        this.historyExportRepository.save(historyExport);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(e ->
        {
            HistoryExport a = jpaStreamer.stream(HistoryExport.class).filter(f -> f.getId() == e).findFirst().get();
            a.setIsDeleted(1);
            historyExportRepository.save(a);
        });
    }
}
