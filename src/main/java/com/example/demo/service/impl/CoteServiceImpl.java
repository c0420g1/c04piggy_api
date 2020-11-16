package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.*;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;
import com.example.demo.service.HistoryExportService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class CoteServiceImpl implements CoteService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    CoteRepository coteRepository;


    // Trả về danh sách chuồng heo đầy đủ
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


    // Trả về danh sách chuồng heo rút gọn
    @Override
    public List<CoteDTO> searchCote(int pageNum, String search){
        List<CoteDTO> coteList = new ArrayList<>();
        String temp ="";
        try{
            if (temp.equals(search)){
                jpaStreamer.stream(Cote.class).skip((pageNum - 1) * pageSize).limit(pageSize)
                        .sorted(Cote$.id.reversed())
                        .collect(Collectors.toList())
                        .forEach(cote ->{
                            // Tìm ra các con heo có cùng mã số đàn => số lượng
                            List<Pig> pigList = new ArrayList<>();
                            try{
                                pigList = jpaStreamer.stream(Pig.class).filter(pig -> (pig.getHerd().getName().contains(cote.getHerd().getName()) && pig.getIsDeleted() ==0)).collect(Collectors.toList());
                            } catch (Exception e){
                                System.out.println("Get Pig get same Herd + "+ e.getMessage());
                            }
                            int quantity = pigList.size();
                            String exportDate= "";
                            if(cote.getExportDate() != null){
                                exportDate = cote.getExportDate().toString();
                            }
                            //  Tìm ra số ngày đã nuôi heo => trạng thái
                            LocalDate now = LocalDate.now();
                            int day = (int) ChronoUnit.DAYS.between(cote.getImportDate(),now);
                            String status = this.StatusPig(day);
                            CoteDTO coteDTO = CoteDTO.builder()
                                    .id(cote.getId())
                                    .coteCode(cote.getCode())
                                    .herdName(cote.getHerd().getName())
                                    .employeeName(cote.getEmployee().getName())
                                    .importDate(cote.getImportDate().toString())
                                    .exportDate(exportDate)
                                    .quantity(quantity)
                                    .day(day)
                                    .status(status).build();
                            coteList.add(coteDTO);
                        });
            } else{
                jpaStreamer.stream(Cote.class).filter(e -> e.getEmployee().getName().contains(search)
                        || e.getHerd().getName().contains(search)
                        || e.getCode().contains(search))
                        .sorted(Cote$.id.reversed())
                        .collect(Collectors.toList()).stream().skip((pageNum - 1) * pageSize).limit(pageSize)
                        .forEach(cote -> {
                            // Tìm ra các con heo có cùng mã số đàn => số lượng
                            List<Pig> pigList = new ArrayList<>();
                            try{
                                pigList = jpaStreamer.stream(Pig.class).filter(pig -> (pig.getHerd().getName().contains(cote.getHerd().getName()) && pig.getIsDeleted() ==0)).collect(Collectors.toList());
                            } catch (Exception e){
                                System.out.println("Get Pig get same Herd + "+ e.getMessage());
                            }
                            int quantity = pigList.size();
                            String exportDate= "";
                            if(cote.getExportDate() != null){
                                exportDate = cote.getExportDate().toString();
                            }
                            //  Tìm ra số ngày đã nuôi heo => trạng thái
                            LocalDate now = LocalDate.now();
                            int day = (int) ChronoUnit.DAYS.between(cote.getImportDate(),now);
                            String status = this.StatusPig(day);
                            CoteDTO coteDTO = CoteDTO.builder()
                                    .id(cote.getId())
                                    .coteCode(cote.getCode())
                                    .herdName(cote.getHerd().getName())
                                    .employeeName(cote.getEmployee().getName())
                                    .importDate(cote.getImportDate().toString())
                                    .exportDate(exportDate)
                                    .quantity(quantity)
                                    .day(day)
                                    .status(status).build();
                            coteList.add(coteDTO);
                        });
            }
        }catch (Exception e){
            System.out.println("Get CoteDTO + "+ e.getMessage());
        }
        return coteList;
    }

    // Tra ve so lượng chuồng.
    @Override
    public List<Cote> searchCoteNoPagination(String search) {
        List<Cote> coteList = new ArrayList<>();
        String temp ="";
        try{
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
        }catch (Exception e){
            System.out.println("Get size of Cote list + " + e.getMessage());
        }
        return coteList;
    }

    @Override
    public List<Pig> getAllPig(String herdCode) {
        List<Pig> pigList = new ArrayList<>();
        try{
            pigList = jpaStreamer.stream(Pig.class).filter(e -> e.getHerd().getName().contains(herdCode) && e.getIsDeleted() == 0).collect(Collectors.toList());
            for (int i =0; i< pigList.size();i++) {
                pigList.get(i).getWeight();
            }
        }catch (Exception e){
            System.out.println("get List Pig + "+ e.getMessage());
        }
        return pigList;
    }

    // tra ve trang thai cua heo
    public String StatusPig(int day){
        String status;
        if (day >= 112){
            status = "Finishing Pig";
        } else if (day >= 63){
            status = "Developing Pig";
        }else if (day >= 35){
            status = "Growing Pig";
        } else if (day >= 21){
            status = "Nursery Pig";
        } else {
            status = "Piglet";
        }
        return status;
    }

//    public static void main(String[] args) {
//        LocalDate c = LocalDate.now();
//        LocalDate a = LocalDate.of(2020,11,10);
//        LocalDate b = LocalDate.of(2020,11,14);
//        System.out.println(ChronoUnit.DAYS.between(a,c));
//            }
}

