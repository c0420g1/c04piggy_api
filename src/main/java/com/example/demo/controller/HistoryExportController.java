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
    //creator Hieu
    @GetMapping("/export-management/{pageNum}")
    public List<HistoryExportDTO> getAll(@PathVariable int pageNum , @RequestParam(defaultValue = "") String search){
        List<HistoryExportDTO> dtoList = null;
        try {
            dtoList = this.historyExportService.getAllDTO(pageNum, search);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
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
    @GetMapping("/historyExportStockDTO/{pageNum}")
    public List<HistoryExportStockDTO> getHistoryExportStockDTO(@PathVariable int pageNum,
                                                                @RequestParam(defaultValue = "") String search){
        try {
            return historyExportService.getHistoryExportStockDTO(pageNum, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //creator Hieu
    @PostMapping("/delExCote")
    public int deleteExportCote(@RequestBody int[] ids){
        for (int id :
                ids) {
            System.out.print( id);
        }
        try {
            this.historyExportService.delete(ids);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 1;
    }
    //creator Hieu
    @PostMapping ("/saveExportCote")
    public int saveCoteExport(@RequestBody HistoryExport historyExportDTO){
        System.out.println(historyExportDTO.toString());
        return this.historyExportService.save( historyExportDTO);
    }


    @GetMapping("/t/{pageNum}")
    public List<HistoryExportDTO> getDTO (@PathVariable int pageNum,
                                          @RequestParam(defaultValue = "") String search){
        return this.historyExportService.getDTO(pageNum, search);
    }
}
