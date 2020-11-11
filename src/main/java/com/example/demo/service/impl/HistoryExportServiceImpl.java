package com.example.demo.service.impl;

import com.example.demo.model.Cote;
import com.example.demo.model.HistoryExport;
import com.example.demo.repository.HistoryExportRepository;
import com.example.demo.service.BaseService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HistoryExportServiceImpl implements BaseService<HistoryExport> {
    @Autowired
    private JPAStreamer jpaStreamer;
    @Autowired
    private HistoryExportRepository historyExportRepository;
    @Override
    public List<HistoryExport> getAll() {
        List<HistoryExport> exportList =  null;
        try {
            exportList = jpaStreamer.stream(HistoryExport.class).collect(Collectors.toList());
        }catch (Exception e){
            e.getMessage();
        }
        return exportList;
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
        Arrays.stream(ids).forEach(e -> {
            HistoryExport a = jpaStreamer.stream(HistoryExport.class).filter(f -> f.getId() == e).findFirst().get();
            a.setIsDeleted(1);
            historyExportRepository.save(a);
        });
    }
}
