package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;


public interface StockService extends BaseService<Stock>{
    List<StockDTO> search(int pageNumber, String search);
    List<Stock> searchStock(int pageNum, String search);
}
