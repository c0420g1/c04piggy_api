package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.Stock;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
