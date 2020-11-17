package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;
import com.example.demo.service.impl.CoteServiceImpl;
import com.example.demo.service.impl.HistoryExportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class HistoryExportController {

    @Autowired
    private HistoryExportServiceImpl historyExportService;


    @GetMapping("export-management/{pageNum}")
    public List<HistoryExportDTO> getAll(@PathVariable int pageNum , @RequestParam(defaultValue = "") String search){
        return this.historyExportService.getAllDTO(pageNum, search);
    }


    @PutMapping("delCoteExport")
    public int delete(@RequestBody int[] ids){
        try {
            this.historyExportService.delete(ids);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    @PutMapping("/exportCote")
    public int exportCote(@RequestBody HistoryExport historyExport, @RequestParam int idCote){
        return historyExportService.exportAllInCote(idCote,historyExport);
    }
    @PutMapping("/exportPigs")
    public int exportPigs(@RequestBody HistoryExport historyExport, @RequestParam String ids){
        String[] idPigs = ids.split(",");
        int[] idSold = new int[ids.length()];
        for (int i = 0; i < idPigs.length; i++) {
            idSold[i] = Integer.parseInt(idPigs[i]);
        }
      return   historyExportService.addPigExport(idSold, historyExport);
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
