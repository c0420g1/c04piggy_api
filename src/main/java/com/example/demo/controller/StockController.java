
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

    // lay ve 1 list StockDTO
    @GetMapping("/getStock/{pageNum}")
    public List<StockDTO> getListStockDTO(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search){
        try {
            return stockService.search(pageNum,pageSize, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // them hoac sua 1 record Stock
    @PostMapping("addEditStock")
    public int addEditStock(@RequestBody StockDTO stockDTO){
      stockService.addEditStock(stockDTO);
        return 1;
    }

    // xoa 1 record Stock
    @PutMapping("deleteStock")
    public int deleteStock(@RequestBody int[] ids){
        return stockService.delete(ids);
    }

    //xuat kho (khau tru so luong 1 record trong stock (kho))
    @PutMapping("exportOutStock/{id}")
    public int exportOutStock(@PathVariable int id, @RequestParam int quantity){
        Stock stock = stockService.getById(id).get();
        if (stock.getQuantity() > quantity){
            stock.setQuantity(stock.getQuantity() - quantity);
            stockService.save(stock);
            return 1;
        }else {
            return 0;
        }
    }

    // lay ve 1 record stock theo id
    @GetMapping("getStockById/{id}")
    public Stock getStockById(@PathVariable int id){
        return stockService.getById(id).get();
    }
}
