package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.HistoryExportRepository;
import com.example.demo.repository.PigAssociateStatusRepository;
import com.example.demo.repository.PigRepository;
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
    @Autowired
    private CoteServiceImpl coteService;
    private static List<HistoryExportDTO> exportDTOList;
    private static List<Pig> pigList;
    private static HistoryExportDTO historyExportDTO;
    @Autowired
    private PigRepository pigRepository;
    @Autowired
    private PigAssociateStatusRepository pigAssociateStatusRepository;

    @Override
    public List<HistoryExportDTO> getAllDTO(int pageNum, String search) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        exportDTOList = new ArrayList<>();
        try {
            if (pageNum == -1) {
                jpaStreamer.stream(HistoryExport.class)
                        .filter(
                                e ->
                                        e.getIsDeleted() == 0 && e.getType().equals("cote")
                                                && (e.getCote().getCode().toLowerCase().contains(search.toLowerCase()) ||
                                                e.getEmployee().getName().toLowerCase().contains(search.toLowerCase()) ||
                                                e.getCompany().toLowerCase().contains(search.toLowerCase()) ||
                                                e.getExportDate().toString().contains(search))
                        )
                        .collect(Collectors.toList()).stream()
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
        }catch (Exception e){
            System.out.println("export list :" +e.getMessage());
        }
        return exportDTOList;

    }

    // Tuong
    // lay ve 1 list History StockDTO de hien thi lich su xoa, co phan trang va tim kiem
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
                                        || e.getUnit().toLowerCase().contains(search.toLowerCase())
                                        || e.getEmployee().getName().toLowerCase().contains(search.toLowerCase())
                                        )).sorted(HistoryExport$.id.reversed()).forEach(e -> {
                    String receivedEmployeeName = (jpaStreamer.stream(Employee.class).filter(f-> f.getId() == e.getReceivedEmployeeId()).findFirst()).get().getName();
                    HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
                            e.getStock().getFeedType().getName(),e.getStock().getVendor().getName(),e.getExportDate(),e.getQuantity(),
                            e.getUnit(),e.getEmployee().getName(),receivedEmployeeName);
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
                                    || e.getEmployee().getName().toLowerCase().contains(search.toLowerCase())
                            )).sorted(HistoryExport$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                                String receivedEmployeeName = (jpaStreamer.stream(Employee.class).filter(f-> f.getId() == e.getReceivedEmployeeId()).findFirst()).get().getName();
                HistoryExportStockDTO historyExportStockDTO = new HistoryExportStockDTO(e.getId(),e.getType(),e.getStock().getShipmentCode(),
                        e.getStock().getFeedType().getName(),e.getStock().getVendor().getName(),e.getExportDate(),e.getQuantity(),
                        e.getUnit(),e.getEmployee().getName(),receivedEmployeeName);
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



    // Tuong
    // lay ve 1 list History Export
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


    public int addPigExport(int[] idPigs, HistoryExport historyExport){
        List<Pig> pigListSold = jpaStreamer.stream(Pig.class).filter(g -> g.getIsDeleted()==0).collect(Collectors.toList());
        List<Integer> pigIds = new ArrayList<>();
        for (int i = 0; i < idPigs.length; i++) {
            pigIds.add(idPigs[i]);
        }
        int weight = 0;
        for (Pig h: pigListSold){
            for (int id: pigIds) {
                      if (id==h.getId()){
                          PigAssociateStatus pigAssociateStatus = new PigAssociateStatus();
                          pigAssociateStatus.setPig(h);
                          pigAssociateStatus.setPigStatus(jpaStreamer.stream(PigStatus.class)
                                  .filter(PigStatus$.name.equal("Sold")).findFirst().get());
                          pigAssociateStatusRepository.save(pigAssociateStatus);
                          h.setIsDeleted(1);
                          weight+= h.getWeight();
                          pigRepository.save(h);
                          historyExport.setCote(h.getCote());
                          historyExport.setQuantity(idPigs.length);
                          historyExport.setType("cote");
                          historyExport.setReceivedEmployeeId(weight);
                          historyExportRepository.save(historyExport);

                      }
            }
        }

        return 0;

    }


}
