//Creator Tuong

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

    @GetMapping("/getStock/{pageNum}")
    public List<StockDTO> getListStockDTO(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search){
        try {
            return stockService.search(pageNum,pageSize, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("addEditStock")
    public int addEditStock(@RequestBody Stock stock){
        return stockService.save(stock);
    }

    @PutMapping("deleteStock")
    public int deleteStock(@RequestBody int[] ids){
        return stockService.delete(ids);
    }

    @PutMapping("exportOutStock")
    public int exportOutStock(@RequestBody int[] ids, @RequestParam int quantity){
        return stockService.exportOutStock(ids, quantity);
    }
}
