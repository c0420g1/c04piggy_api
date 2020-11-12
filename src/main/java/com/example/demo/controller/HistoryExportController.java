package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportStockDTO;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryExportController {

    @Autowired
    private HistoryExportServiceImpl historyExportService;

    @GetMapping("/export-management")
    public List<HistoryExport> getAll(){
        return this.historyExportService.getAll();
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
