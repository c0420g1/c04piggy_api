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
import com.example.demo.model.TreatmentVacxin;
import com.example.demo.model.TreatmentVacxin$;
import com.example.demo.model.TreatmentVacxinDTO;


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
    public void save(TreatmentVacxin treatmentVacxin) {
        try{
            treatmentVacxinRepository.save(treatmentVacxin);
        }catch (Exception e){
            e.getMessage();
        }

    }

//      dương nhật huy
//      delete one or more treatment
    @Override
    public void delete(int[] ids) {
        try{
            Arrays.stream(ids).forEach(e -> {
                TreatmentVacxin treatmentVacxin = jpaStreamer.stream(TreatmentVacxin.class)
                        .filter(f ->f.getId() ==e).findFirst().get();
                treatmentVacxin.setIsDeleted(1);
                treatmentVacxinRepository.save(treatmentVacxin);
            });
        }catch (Exception e){
            e.getMessage();
        }
    }

//      dương nhật huy
//      show all list treamentDTO by pagination and search
    @Override
    public List<TreatmentVacxinDTO> search(int pageNumber, String search, String type){
        List<TreatmentVacxinDTO> treatmentVacxinDTOList =new ArrayList<>();
        try{
            jpaStreamer.stream(TreatmentVacxin.class).filter(e->e.getIsDeleted()==0 && e.getType().equals(type) && (e.getVeterinary().contains(search)
                    || e.getVacxin().getName().contains(search) || e.getDiseases().getName().contains(search) || e.getTreatDate().toString().contains(search)
                    || e.getPig().getCode().contains(search) || e.getCote().getCode().contains(search))
            ).sorted(TreatmentVacxin$.id.reversed()).skip((pageNumber-1)* GlobalUtil.pageSize).limit(GlobalUtil.pageSize).forEach(f->{
                TreatmentVacxinDTO t= TreatmentVacxinDTO.builder().id(f.getId()).treatDate(f.getTreatDate()).coteCode(f.getCote().getCode())
                        .diseases(f.getDiseases().getName()).pigCode(f.getPig().getCode()).vacxin(f.getVacxin()
                                .getName()).veterinarian(f.getVeterinary()).build();
                treatmentVacxinDTOList.add(t);
            });
            return treatmentVacxinDTOList;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
