package com.example.demo.service.impl;
import com.example.demo.repository.TreatmentVacxinRepository;
import com.example.demo.service.TreamentVacxinService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.common.GlobalUtil;
import com.example.demo.model.*;

@Service
public class TreatmentVacxinServiceImpl implements TreamentVacxinService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    TreatmentVacxinRepository treatmentVacxinRepository;

//    dương nhật huy
//    get all list treatment
    @Override
    public List<TreatmentVacxin> getAll() {
        List<TreatmentVacxin> treatmentVacxinList;
        try{
            treatmentVacxinList = jpaStreamer.stream(TreatmentVacxin.class).collect(Collectors.toList());
            return treatmentVacxinList;
        }catch (Exception e){
            e.getMessage();
        }
       return null;
    }

//      dương nhật huy
//      get treatment by id
    @Override
    public Optional<TreatmentVacxin> getById(int id) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        try{
            return jpaStreamer.stream(TreatmentVacxin.class).filter(e -> e.getId() == id).findFirst();
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

//      dương nhật huy
//      save treatment
    @Override
    public int save(TreatmentVacxin treatmentVacxin) {
        try{
            treatmentVacxinRepository.save(treatmentVacxin);
            return 1;
        }catch (Exception e){
            e.getMessage();
        }
        return 0;
    }

//      dương nhật huy
//      delete one or more treatment
    @Override
    public int delete(int[] ids) {
        try{
            Arrays.stream(ids).forEach(e -> {
                TreatmentVacxin treatmentVacxin = jpaStreamer.stream(TreatmentVacxin.class)
                        .filter(f ->f.getId() ==e).findFirst().get();
                treatmentVacxin.setIsDeleted(1);
                treatmentVacxinRepository.save(treatmentVacxin);
            });
            return 1;
        }catch (Exception e){
            e.getMessage();
        }
        return 0;
    }

//      dương nhật huy
//      show all list treamentDTO by pagination and search
    @Override
    public List<TreatmentVacxinDTO> search(int pageNumber, String search, String type){
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<TreatmentVacxinDTO> treatmentVacxinDTOList =new ArrayList<>();
        try{
            if (pageNumber == -1){
                jpaStreamer.stream(TreatmentVacxin.class).filter(e->e.getIsDeleted()==0 && e.getType().equals(type) && (e.getVeterinary().contains(search)
                        || e.getVacxin().getName().contains(search) || e.getDiseases().getName().contains(search) || e.getTreatDate().toString().contains(search)
                        || e.getPig().getCode().contains(search) || e.getCote().getCode().contains(search))
                ).sorted(TreatmentVacxin$.id.reversed()).forEach(f->{
                    TreatmentVacxinDTO t= TreatmentVacxinDTO.builder().id(f.getId()).treatDate(f.getTreatDate()).coteCode(f.getCote().getCode())
                            .diseases(f.getDiseases().getName()).pigCode(f.getPig().getCode()).vacxin(f.getVacxin()
                                    .getName()).veterinarian(f.getVeterinary()).build();
                    treatmentVacxinDTOList.add(t);
                });
                return treatmentVacxinDTOList;
            }
            jpaStreamer.stream(TreatmentVacxin.class).filter(e->e.getIsDeleted()==0 && e.getType().equals(type) && (e.getVeterinary().contains(search)
                    || e.getVacxin().getName().contains(search) || e.getDiseases().getName().contains(search) || e.getTreatDate().toString().contains(search)
                    || e.getPig().getCode().contains(search) || e.getCote().getCode().contains(search))
            ).sorted(TreatmentVacxin$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)* GlobalUtil.pageSize).limit(GlobalUtil.pageSize).forEach(f->{
                TreatmentVacxinDTO t= TreatmentVacxinDTO.builder().id(f.getId()).treatDate(f.getTreatDate()).coteCode(f.getCote().getCode())
                        .diseases(f.getDiseases().getName()).pigCode(f.getPig().getCode()).vacxin(f.getVacxin()
                                .getName()).veterinarian(f.getVeterinary()).build();
                treatmentVacxinDTOList.add(t);
            });
            jpaStreamer.close();
            return treatmentVacxinDTOList;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }


// dương nhật huy
// get list pig by id cote
    @Override
    public List<Pig> getListPig(int coteID) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        try {
            List<Pig> pigList = jpaStreamer.stream(Pig.class).filter(e -> e.getCote().getId() == coteID && e.getIsDeleted() == 0).collect(Collectors.toList());
            return pigList;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Diseases> getListDiseases() {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        return jpaStreamer.stream(Diseases.class).collect(Collectors.toList());
    }

    @Override
    public List<Vacxin> getListVacxin() {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        return jpaStreamer.stream(Vacxin.class).collect(Collectors.toList());
    }

    @Override
    public List<VaccineInfoDTO> getDataVaccine(int pageNumber, String search, String type) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<VaccineInfoDTO> treatmentVacxinDTOList =new ArrayList<>();
        try{
            if (pageNumber == -1){
                jpaStreamer.stream(TreatmentVacxin.class).filter(e->e.getIsDeleted()==0 && e.getType().equals(type) && (e.getVeterinary().contains(search)
                         || e.getDiseases().getName().contains(search) || e.getTreatDate().toString().contains(search)
                         || e.getCote().getCode().contains(search))
                ).sorted(TreatmentVacxin$.id.reversed()).forEach(f->{
                    VaccineInfoDTO t= VaccineInfoDTO.builder().id(f.getId()).treatDate(f.getTreatDate()).coteCode(f.getCote().getCode())
                            .diseases(f.getDiseases().getName()).veterinarian(f.getVeterinary()).build();
                    treatmentVacxinDTOList.add(t);
                });
                return treatmentVacxinDTOList;
            }
            jpaStreamer.stream(TreatmentVacxin.class).filter(e->e.getIsDeleted()==0 && e.getType().equals(type) && (e.getVeterinary().contains(search)
                    || e.getDiseases().getName().contains(search) || e.getTreatDate().toString().contains(search)
                    || e.getCote().getCode().contains(search))
            ).sorted(TreatmentVacxin$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)* GlobalUtil.pageSize).limit(GlobalUtil.pageSize).forEach(f->{
                VaccineInfoDTO t= VaccineInfoDTO.builder().id(f.getId()).treatDate(f.getTreatDate()).coteCode(f.getCote().getCode())
                        .diseases(f.getDiseases().getName()).veterinarian(f.getVeterinary()).build();
                treatmentVacxinDTOList.add(t);
            });
            jpaStreamer.close();
            return treatmentVacxinDTOList;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
