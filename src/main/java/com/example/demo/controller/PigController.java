package com.example.demo.controller;

import com.example.demo.model.Pig;
import com.example.demo.model.PigDTO;
import com.example.demo.service.PigService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PigController {
    private static final Log errorLog = LogFactory.getLog(PigController.class);

    @Autowired
    private PigService pigService;

    @GetMapping("/pigList/{pageNum}")
    public List<PigDTO> getPigListShow(@PathVariable int pageNum, @RequestParam(defaultValue = "") String search){
        try {
            return pigService.listPigSearch(pageNum, search);
        }catch (Exception e){
            errorLog.error("lỗi tại pigListShow" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/pigListFull")
    public List<Pig> getPigList(){
        try {
            return pigService.getAll();
        }catch (Exception e){
            errorLog.error("lỗi tại pigList" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/pigDetail")
    public Optional<Pig> getPigDetail(@RequestParam int id) {
        try {
            return pigService.getById(id);
        }catch (Exception e){
            errorLog.error("Lỗi tại getPigDetail" + e.getMessage());
            return null;
        }
    }

    @PostMapping("/addPig")
    public void addPig(@RequestBody Pig pigAdd) {
        try {
            pigService.save(pigAdd);
        }catch (Exception e){
            errorLog.error("lỗi tại vị trí addPig" + e.getMessage());
        }
    }

    @PatchMapping("/editPig")
    public void editPig(@RequestBody Pig editPig) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(editPig);
        try {
            pigService.save(editPig);
        }catch (Exception e){
            errorLog.error("Lỗi tại vị trí editPig" + e.getMessage());
        }
    }

    @PatchMapping("/deletePig")
    public void deletePig(@RequestBody int[] ids){
        try {
            pigService.delete(ids);
        }catch (Exception e){
            errorLog.error("lỗi tại pigDelete" + e.getMessage());
        }
    }

    //add new born pig
    @PostMapping("/addNewBornPig")
    public void addNewBornPig(@RequestBody Pig pigAdd) {
        pigService.saveNewPig(pigAdd);
    }

    //sold pig
    @GetMapping("/soldPig")
    public void soldPig(@RequestParam int id) {
        try {
            pigService.soldPig(id);
        } catch (Exception e) {
            errorLog.error("Lỗi tại vị trí soldPig" + e.getMessage());
        }
    }
}
