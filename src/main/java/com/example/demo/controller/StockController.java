package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Cote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;
import com.example.demo.service.StockService;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    //Creator Tuong
    @GetMapping("idStock/{id}")
    public Stock getById(@PathVariable int id){
        Stock stock;
            stock = stockService.getById(id).orElse(null);
            return stock;

    }

    //Creator Tuong
    //List has Pagination & Search
    @GetMapping("stock/{pageNum}")
    public List<Stock> getAllPagination(@RequestParam(defaultValue = "") String search,
                                       @PathVariable int pageNum){
        List<Stock> stockList;
        try {
            stockList = stockService.searchStock(pageNum,search);
            return stockList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Creator Tuong
    @GetMapping("getListStockDTO")
    public List<StockDTO> getListStockDTO(@PathVariable int pageNum, @RequestParam String search){
        try {
            return stockService.search(pageNum, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Creator Tuong
    // get list Stock, with no pagination
    @GetMapping("listStock")
    public List<Stock> getListStock(){
        List<Stock> stockList;
        stockList = stockService.getAll();
        return stockList;
    }

    //Creator Tuong
    // add new Stock, with no pagination
    @PostMapping("stock")
    public void addNewStock(@RequestBody Stock stock){
        try {
            stockService.save(stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
