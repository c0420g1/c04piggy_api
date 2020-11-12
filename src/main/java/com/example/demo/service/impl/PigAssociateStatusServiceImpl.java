package com.example.demo.service.impl;

import com.example.demo.model.PigAssociateStatus;
import com.example.demo.repository.PigAssociateStatusRepository;
import com.example.demo.service.PigAssociateStatusService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PigAssociateStatusServiceImpl implements PigAssociateStatusService {
    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private PigAssociateStatusRepository pigAssociateStatusRepository;

    @Override
    public List<PigAssociateStatus> getAll() {
        List<PigAssociateStatus> pigAssociateStatusList;
        pigAssociateStatusList = jpaStreamer.stream(PigAssociateStatus.class).collect(Collectors.toList());
        return pigAssociateStatusList;
    }

    @Override
    public List<PigAssociateStatus> getAllByPigId(int pigId) {
        List<PigAssociateStatus> pigAssociateStatusList;
        pigAssociateStatusList = jpaStreamer.stream(PigAssociateStatus.class)
                .filter(f -> f.getPig().getId() == pigId).collect(Collectors.toList());
        return pigAssociateStatusList;
    }

    @Override
    public Optional<PigAssociateStatus> getById(int id) {
        return jpaStreamer.stream(PigAssociateStatus.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(PigAssociateStatus pigAssociateStatus) {
        pigAssociateStatusRepository.save(pigAssociateStatus);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(pigAssociateStatusListIdReceive ->
        {
            PigAssociateStatus pigAssociateStatusDB = jpaStreamer.stream(PigAssociateStatus.class).filter(f -> f.getId() == pigAssociateStatusListIdReceive).findFirst().get();
            pigAssociateStatusDB.setIsDeleted(1);
            pigAssociateStatusRepository.save(pigAssociateStatusDB);
        });
    }
}
