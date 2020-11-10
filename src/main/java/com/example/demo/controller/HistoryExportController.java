package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
