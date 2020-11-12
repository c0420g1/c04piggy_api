package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;
import com.example.demo.service.impl.CoteServiceImpl;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HistoryExportController {

    @Autowired
    private HistoryExportServiceImpl historyExportService;
    @Autowired
    private CoteServiceImpl coteService;

    @GetMapping("/export-management")
    public List<HistoryExportDTO> getAll(){
        return this.historyExportService.getAllDTO();
    }
    @GetMapping("/search/{pageNum}")
    public List<HistoryExportDTO> searchAll(@PathVariable int pageNum , @RequestParam(defaultValue = "") String search){
        return  this.historyExportService.search(pageNum,search);
    }
    //Creator Tuong
    // add new HistoryExport
    @PostMapping("/export-management")
    public void addExportManagement(@RequestBody HistoryExport historyExport){
        try {
            historyExportService.save(historyExport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Creator Tuong
    // get List HistoryExport Stock
    @GetMapping("/historyExportStock/{pageNum}")
    public List<HistoryExportStockDTO> getHistoryExportStockDTO(@PathVariable int pageNum,
                                                                @RequestParam(defaultValue = "") String search){
        try {
            return historyExportService.getHistoryExportStockDTO(pageNum, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
