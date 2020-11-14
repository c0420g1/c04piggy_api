package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

import static com.example.demo.common.GlobalUtil.pageSize;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    JPAStreamer jpaStreamer;

    @Autowired
    StockRepository stockRepository;

    // creator: Tuong
    // lay ve mot danh sach stock
    @Override
    public List<Stock> getAll() {
        List<Stock> stockList= new ArrayList<>();
        try {
            JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
            stockList = jpaStreamer.stream(Stock.class).collect(Collectors.toList());
             jpaStreamer.close();
            return stockList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // creator: Tuong
    // lay ve mot stock boi id
    @Override
    public Optional<Stock> getById(int id) {
        try {
            return jpaStreamer.stream(Stock.class).filter(e -> e.getId() == id).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // creator: Tuong
    // luu mot stock
    @Override
    public int save(Stock stock) {
        try {
            stockRepository.save(stock);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // creator: Tuong
    // xoa mot list stock boi array id
    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(e ->
            {
                Stock a = jpaStreamer.stream(Stock.class).filter(f -> f.getId() == e).findFirst().get();
                a.setIsDeleted(1);
                stockRepository.save(a);

            });
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // creator: Tuong => tim kiem nhieu truong
    @Override
    public List<StockDTO> search(int pageNumber, String search) {
        List<StockDTO> stockDTOList = new ArrayList<>();
        try {
            JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
            jpaStreamer.stream(Stock.class).filter(e ->
                    e.getIsDeleted()==0 &&
                    e.getShipmentCode().contains(search) ||
                    e.getFeedType().getName().contains(search) || e.getVendor().getName().contains(search)
                    || e.getExpDate().toString().contains(search) || String.valueOf(e.getQuantity()).contains(search)
                    || e.getUnit().contains(search)).skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                StockDTO stockDTO = new StockDTO(e.getId(),e.getShipmentCode(), e.getFeedType().getName(),
                        e.getVendor().getName(),e.getMfgDate(), e.getExpDate(), e.getQuantity(), e.getUnit(), e.getImportDate());
                stockDTOList.add(stockDTO);
            });
            return stockDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // creator: Tuong => tim kiem nhieu truong
    @Override
    public List<Stock> searchStock(int pageNum, String search) {
        List<Stock> stockList;
        String temp ="";
        try {
            if (temp.equals(search)){
                JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
                stockList = jpaStreamer.stream(Stock.class).skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            } else{
                JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
                stockList = jpaStreamer.stream(Stock.class).filter(e -> e.getShipmentCode().contains(search)
                        || e.getFeedType().getName().contains(search)
                        || e.getVendor().getName().contains(search)
                        || e.getExpDate().toString().contains(search)
                        || String.valueOf(e.getQuantity()).contains(search)
                        || e.getUnit().contains(search)).skip((pageNum - 1) * pageSize).limit(pageSize)
                        .collect(Collectors.toList());
            }
            return stockList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
