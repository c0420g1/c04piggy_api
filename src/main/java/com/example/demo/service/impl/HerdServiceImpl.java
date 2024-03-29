package com.example.demo.service.impl;

import com.example.demo.model.Herd;
import com.example.demo.repository.HerdRepository;
import com.example.demo.service.HerdService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class HerdServiceImpl implements HerdService {

    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private HerdRepository herdRepository;

    @Override
    public List<Herd> getAllHerdList(int pageNumber) {
        try {
            if (pageNumber == -1) {
                return jpaStreamer.stream(Herd.class).filter(f -> f.getIsDeleted() == 0).collect(Collectors.toList());
            } else {
                return jpaStreamer.stream(Herd.class).filter(f -> f.getIsDeleted() == 0).collect(Collectors.toList()).stream().skip((pageNumber - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            }
        }catch (Exception e){
            System.out.println("loi tai get herd Impl" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Herd> getAll() {
        return jpaStreamer.stream(Herd.class).filter(e -> e.getIsDeleted() == 0).collect(Collectors.toList());
    }

    @Override
    public Optional<Herd> getById(int id) {
        return jpaStreamer.stream(Herd.class).filter(e ->e.getIsDeleted() == 0 && e.getId() == id).findFirst();
    }

    @Override
    public int save(Herd herd)
        {
            try {
                herdRepository.save(herd);
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }

    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(herdListIdReceive ->
            {
                Herd herdDB = jpaStreamer.stream(Herd.class).filter(f -> f.getId() == herdListIdReceive).findFirst().get();
                herdDB.setIsDeleted(1);
                herdRepository.save(herdDB);
            });
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }
}
