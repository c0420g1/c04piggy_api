package com.example.demo.controller;

import java.util.List;


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
    //List has Pagination & Search
    @GetMapping("/stockDTO/{pageNum}")
    public List<StockDTO> getListStockDTO(@PathVariable int pageNum, @RequestParam(defaultValue = "") String search){
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

    //Creator Tuong
    // edit Stock, with no pagination
    @PutMapping("stock")
    public void editStock(@RequestBody Stock stock){
        try {
            stockService.save(stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Creator Tuong
    // edit Stock, with no pagination
    @DeleteMapping("stock")
    public void deleteStock(@RequestBody int[] ids){
        try {
            stockService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Creator Tuong
    // edit Stock, with no pagination
    @PutMapping("editStockExport/{id}")
    public void editStockExport(@RequestBody int quantityExport, @PathVariable int id){
       Stock stock;
       try {
           stock = stockService.getById(id).orElse(null);
           if (stock.getQuantity() >= quantityExport){
               stock.setQuantity(stock.getQuantity() - quantityExport);
           }
           stockService.save(stock);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
