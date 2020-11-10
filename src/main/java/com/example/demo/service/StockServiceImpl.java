package com.example.demo.service;

import com.example.demo.model.Stock;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;

public class StockServiceImpl implements StockService{
    @Autowired
    JPAStreamer jpaStreamer;

    @Override
    public void save(Stock stock) {
        
    }

    @Override
    public void delete(int[] ids) {

    }
}
