package com.example.demo.service.impl;

import com.example.demo.model.TreatmentVacxin;
import com.example.demo.repository.TreatmentVacxinRepository;
import com.example.demo.service.TreamentVacxinService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreatmentVacxinServiceImpl implements TreamentVacxinService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    TreatmentVacxinRepository treatmentVacxinRepository;
    @Override
    public List<TreatmentVacxin> getAll() {
        List<TreatmentVacxin> treatmentVacxinList;
        treatmentVacxinList = jpaStreamer.stream(TreatmentVacxin.class).collect(Collectors.toList());
        return treatmentVacxinList;
    }

    @Override
    public Optional<TreatmentVacxin> getById(int id) {
        return jpaStreamer.stream(TreatmentVacxin.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(TreatmentVacxin treatmentVacxin) {
        treatmentVacxinRepository.save(treatmentVacxin);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(e -> {
            TreatmentVacxin treatmentVacxin = jpaStreamer.stream(TreatmentVacxin.class)
                    .filter(f ->f.getId() ==e).findFirst().get();
            treatmentVacxin.setIsDeleted(1);
            treatmentVacxinRepository.save(treatmentVacxin);
        });
    }
}
