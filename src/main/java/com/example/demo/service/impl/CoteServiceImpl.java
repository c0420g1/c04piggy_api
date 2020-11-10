package com.example.demo.service.impl;

import com.example.demo.model.Cote;
import com.example.demo.service.CoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoteServiceImpl implements CoteService {
    @Override
    public List<Cote> getAll(int pageNum) {
        return null;
    }


    @Override
    public Optional<Cote> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Cote cote) {

    }

    @Override
    public void delete(int[] ids) {

    }

    @Override
    public List<Cote> search(int pageNum, String search) {
        return null;
    }
}
