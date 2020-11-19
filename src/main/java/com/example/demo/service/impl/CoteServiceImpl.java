package com.example.demo.service.impl;


import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.model.*;
import com.example.demo.repository.CoteRepository;
import com.example.demo.service.CoteService;


import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class CoteServiceImpl implements CoteService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    CoteRepository coteRepository;
    @Autowired
    private PigAssociateStatusServiceImpl pigAssociateStatusService;


    // Trả về danh sách chuồng heo đầy đủ
    @Override
    public List<Cote> getAll() {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
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
        System.out.println(cote);
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
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
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
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
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
        }catch (Exception e){
            System.out.println("get List Pig + "+ e.getMessage());
        }
        return pigList;
    }

    // Tra ve tình trạng sức khỏe của heo
    @Override
    public List<PigDTO> getAllPigDTOAndStatus(String herdCode) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<PigDTO> list = new ArrayList<>();

        try{
            jpaStreamer.stream(Pig.class).filter(e -> e.getHerd().getName().equals(herdCode) && e.getIsDeleted() == 0)
                    .collect(Collectors.toList())
                    .forEach(pig ->{
                        // List Status cho từng con heo
                        List<String> listStatus = new ArrayList<>();
                        jpaStreamer.stream(PigAssociateStatus.class).
                            filter(pigA -> pigA.getPig().getId() == pig.getId()).collect(Collectors.toList()).forEach(b ->{
                                        listStatus.add(b.getPigStatus().getName()); // co the getName() để lấy tình trạng
                                    });

                PigDTO pigDTO = PigDTO.builder()
                        .pigId(pig.getId())
                        .cote(pig.getCode())
                        .importDate(pig.getImportDate())
                        .weight(pig.getWeight())
                        .status(listStatus).build();
                list.add(pigDTO);
            }
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Trả về danh sách chuồng có số lượng bằng 0;
    @Override
    public List<String> getCoteCode() {
        List<String> coteCodeList = new ArrayList<>();
        try {
            jpaStreamer.stream(Cote.class).collect(Collectors.toList()).forEach( cote ->  {
                    List<Pig> pigList = new ArrayList<>();
                    pigList = getAllPig(cote.getHerd().getName());
                    if (pigList.size() == 0) {
                        coteCodeList.add(cote.getCode());
                    }
            });
        }catch (Exception e){
            System.out.println("Get Cote Code:" + e.getMessage());
        }
        return coteCodeList;
    }

    @Override
    public List<Herd> getListHerd() {
        List<Herd> herdList = new ArrayList<>();
        try{
            herdList = jpaStreamer.stream(Herd.class).collect(Collectors.toList());
        }catch (Exception e){
            System.out.println("Get list Herd" + e.getMessage());
        }
        return herdList;
    }


    //creator Hieu
    @Override
    public List<Pig> getAllPigSold() {
        List<Integer> listIdPigSold = pigAssociateStatusService.getAllIdPigSoled();
        List<Pig> pigList = new ArrayList<>();
        for (int idPig :
                listIdPigSold) {
            // in here must filter pig have isDelete = 1 because after sold then this pig hidden in table
            jpaStreamer.stream(Pig.class).filter(
                    h-> h.getIsDeleted() == 1
            ).forEach(
                    g-> {
                        if (idPig == g.getId()){
                            pigList.add(g);
                        }
                    }
            );
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

