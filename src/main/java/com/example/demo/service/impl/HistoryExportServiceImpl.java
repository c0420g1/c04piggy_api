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
    private static List<HistoryExportDTO> exportDTOList = new ArrayList<>();


    @Override
    public List<HistoryExportDTO> getAllDTO(int pageNum, String search) {
        try {
            jpaStreamer.stream(HistoryExport.class).skip((pageNum - 1) * pageSize).limit(pageSize)
                    .filter(
                            e ->
                                    e.getIsDeleted() == 0 && (
                                            e.getCompany().contains(search) ||
                                                    e.getEmployee().getCode().contains(search) ||
                                                  e.getCote().getCode().contains(search)
                                                    ||
                                                    e.getExportDate().toString().contains(search))
                    )
                    .forEach(g -> {
                        List<Pig> pigList = coteService.getAllPig(g.getCote().getHerd().getName());
                        int weight = 0;
                        for (int i = 0; i < pigList.size(); i++) {
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
                        exportDTOList.add(h);
                    });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return exportDTOList;
    }

//    @Override
//    public List<HistoryExportStockDTO> getHistoryExportStockDTO(int pageNumber, String search) {
//        List<HistoryExportStockDTO> historyExportStockDTOList = new ArrayList<>();
//        try {
//            JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
//            jpaStreamer.stream(HistoryExport.class).filter(e ->
//                    e.getIsDeleted()==0 && e.getType() == "stock" &&
//                            e.getStock().getShipmentCode().contains(search)
//                            ||e.getStock().getFeedType().getName().contains(search)
//                            ||e.getStock().getVendor().getName().contains(search)
//                            ||String.valueOf(e.getQuantity()).contains(search)
//                            ||e.getUnit().contains(search)
//                            ||e.getEmployee().getName().contains(search)).skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
//                String employeeRecievedName= jpaStreamer.stream(Employee.class).filter(Employee$.id.equal(e.getReceivedEmployeeId())).findFirst().get().getName();
//                HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
//                        e.getStock().getFeedType().getName(), e.getStock().getVendor().getName(),e.getExportDate(), e.getQuantity(),
//                        e.getUnit(), e.getEmployee().getName(), employeeRecievedName);
//                historyExportStockDTOList.add(historyExportStockDTO);
//            });
//            return historyExportStockDTOList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<HistoryExportStockDTO> getAllHistoryStockDTO(int pageNumber, int pageSize, String search) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<HistoryExportStockDTO> historyExportStockDTOList = new ArrayList<>();
        try {
            if(pageNumber==-1){

                jpaStreamer.stream(HistoryExport.class).filter(e ->
                        e.getIsDeleted()==0 && e.getType().equals("stock") &&
                                            (e.getType().toLowerCase().contains(search.toLowerCase())
                                        || e.getStock().getShipmentCode().toLowerCase().contains(search.toLowerCase())
                                        || e.getStock().getFeedType().getName().toLowerCase().contains(search.toLowerCase())
                                        || e.getStock().getVendor().getName().toLowerCase().contains(search.toLowerCase())
                                        || e.getExportDate().toString().contains(search)
                                        || String.valueOf(e.getQuantity()).contains(search)
                                        || e.getUnit().contains(search)
                                        )).sorted(HistoryExport$.id.reversed()).forEach(e -> {
                    HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
                            e.getStock().getFeedType().getName(),e.getStock().getVendor().getName(),e.getExportDate(),e.getQuantity(),
                            e.getUnit(),e.getEmployee().getName(),e.getEmployee().getName());
                    historyExportStockDTOList.add(historyExportStockDTO);
                });
                return historyExportStockDTOList;
            }
            jpaStreamer.stream(HistoryExport.class).filter(e ->
                    e.getIsDeleted()==0 && e.getType().equals("stock") &&
                            (e.getType().toLowerCase().contains(search.toLowerCase())
                                    || e.getStock().getShipmentCode().toLowerCase().contains(search.toLowerCase())
                                    || e.getStock().getFeedType().getName().toLowerCase().contains(search.toLowerCase())
                                    || e.getStock().getVendor().getName().toLowerCase().contains(search.toLowerCase())
                                    || e.getExportDate().toString().contains(search)
                                    || String.valueOf(e.getQuantity()).contains(search)
                                    || e.getUnit().contains(search)
                            )).sorted(HistoryExport$.id.reversed()).forEach(e -> {
                HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
                        e.getStock().getFeedType().getName(),e.getStock().getVendor().getName(),e.getExportDate(),e.getQuantity(),
                        e.getUnit(),e.getEmployee().getName(),e.getEmployee().getName());
                historyExportStockDTOList.add(historyExportStockDTO);
            });
            return historyExportStockDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jpaStreamer.close();
        }
        return null;
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

}
