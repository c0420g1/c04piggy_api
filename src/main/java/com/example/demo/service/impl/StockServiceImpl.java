package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    JPAStreamer jpaStreamer;


    @Override
    public List<Stock> getAll() {
        return null;
    }

    @Override
    public Optional<Stock> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Stock stock) {
        
    }

    @Override
    public void delete(int[] ids) {

    }
}
