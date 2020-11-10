package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;
import com.example.demo.service.StockService;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    //Creator Tuong
    @GetMapping("/getStockById")
    public Stock getById(int id){
        try {
            return stockService.getById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Creator Tuong
    @GetMapping("/getListStockDTO")
    public List<StockDTO> getListStockDTO(@PathVariable int pageNum, @RequestParam String search){
        try {
            return stockService.search(pageNum, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
