package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.HistoryExportRepository;
import com.example.demo.service.BaseService;
import com.example.demo.service.HistoryExportService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<HistoryExportStockDTO> getHistoryExportStockDTO(int pageNumber, String search) {
        List<HistoryExportStockDTO> historyExportStockDTOList = new ArrayList<>();
        try {
            JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
            jpaStreamer.stream(HistoryExport.class).filter(e ->
                    e.getIsDeleted()==0 && e.getType() == "stock" &&
                              e.getStock().getShipmentCode().contains(search)
                            ||e.getStock().getFeedType().getName().contains(search)
                            ||e.getStock().getVendor().getName().contains(search)
                            ||String.valueOf(e.getQuantity()).contains(search)
                            ||e.getUnit().contains(search)
                            ||e.getEmployee().getName().contains(search)).skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                                String employeeRecievedName= jpaStreamer.stream(Employee.class).filter(Employee$.id.equal(e.getReceivedEmployeeId())).findFirst().get().getName();
                HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
                        e.getStock().getFeedType().getName(), e.getStock().getVendor().getName(),e.getExportDate(), e.getQuantity(),
                        e.getUnit(), e.getEmployee().getName(), employeeRecievedName);
                historyExportStockDTOList.add(historyExportStockDTO);
            });
            return historyExportStockDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
