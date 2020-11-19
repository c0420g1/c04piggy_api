package com.example.demo.controller;
import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;
import com.example.demo.service.impl.CoteServiceImpl;
import com.example.demo.service.impl.HistoryExportServiceImpl;
import com.example.demo.service.impl.StockServiceImpl;
import com.speedment.common.json.Json;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HistoryExportController {

    @Autowired
    private HistoryExportServiceImpl historyExportService;

    @GetMapping("export-management/{pageNum}")
    public List<HistoryExportDTO> getAll(@PathVariable int pageNum , @RequestParam(defaultValue = "") String search){
        return this.historyExportService.getAllDTO(pageNum, search);
    }

    //Creator Tuong
    //getAllHistoryExport
    @GetMapping("/getAllHistoryStockDTO/{pageNum}")
    public List<HistoryExportStockDTO> getAllHistoryStockDTO(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search) {
        try {
            return historyExportService.getAllHistoryStockDTO(pageNum, pageSize, search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//
    @PutMapping("delCoteExport")
    public int delete(@RequestBody int[] ids){
        try {
            this.historyExportService.delete(ids);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    @PutMapping("/exportPigs")
    public int exportPigs(@Valid  @RequestBody HistoryExport historyExport, @RequestParam String ids){

        System.out.println("export list pigs " + ids);
        String[] idPigs = ids.split(",");
        int[] idSold = new int[idPigs.length];
        try {

            for (int i = 0; i < idPigs.length; i++) {
                idSold[i] = Integer.parseInt(idPigs[i]);
            }
        }catch (Exception e){
            System.out.println(e.getMessage() + "list pigs export has error or DTO input history export error !");
        }

      return   historyExportService.addPigExport(idSold, historyExport);
    }
//
    //Creator Tuong
    //getAllHistoryExport
    @GetMapping("historyExport")
    public List<HistoryExport> getAllHistoryExport(){
        return this.historyExportService.getAll();
    }
//
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
