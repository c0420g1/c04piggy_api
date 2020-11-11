package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.service.impl.CoteServiceImpl;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryExportController {

    @Autowired
    private HistoryExportServiceImpl historyExportService;
    @Autowired
    private CoteServiceImpl coteService;

    @GetMapping("/export-management")
    public List<HistoryExport> getAll(){
        return this.historyExportService.getAll();
    }
    @GetMapping("/search/{pageNum}")
    public List<HistoryExportDTO> searchAll(@PathVariable int pageNum , @RequestParam(defaultValue = "") String search){
        return  this.historyExportService.search(pageNum,search);
    }
}
