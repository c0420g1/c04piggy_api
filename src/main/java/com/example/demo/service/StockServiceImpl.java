package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;

public class StockServiceImpl implements StockService{
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    StockRepository stockRepository;

    @Override
    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void delete(int[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            stockRepository.deleteById(ids[i]);
        }
    }

//    public Stock findStockById(int id){
//        return jpaStreamer.stream()
//    }

}
