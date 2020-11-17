package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;

// Tuong
// lay ve 1 list StockDTO co phan trang, tim kiem
// them hoac sua 1 record trong kho (stock)
public interface StockService extends BaseService<Stock>{
    List<StockDTO> search(int pageNumber, int pageSize, String search);
    void addEditStock(StockDTO stockDTO);
}
