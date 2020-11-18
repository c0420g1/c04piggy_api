package com.example.demo.controller;

import com.example.demo.model.Herd;
import com.example.demo.service.HerdService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HerdController {
    private static final Log errorLog = LogFactory.getLog(HerdController.class);;

    @Autowired
    private HerdService herdService;

    @GetMapping("herdList/{pageNum}")
    public List<Herd> getHerdList(@PathVariable int pageNum){
        try {
            return herdService.getAllHerdList(pageNum);
        }catch (Exception e){
            errorLog.error("lỗi tại herdList" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/herdDetail")
    public Optional<Herd> getHerdDetail(@RequestParam int id) {
        try {
            return herdService.getById(id);
        }catch (Exception e){
            errorLog.error("Lỗi tại getHerdDetail" + e.getMessage());
            return null;
        }
    }

    @PostMapping("/addHerd")
    public void addHerd(@RequestBody Herd herd) {
        try {
            herdService.save(herd);
        }catch (Exception e){
            errorLog.error("lỗi tại vị trí addHerd" + e.getMessage());
        }
    }

    @PatchMapping("/editHerd")
    public void editHerd(@RequestBody Herd herd) {
        try {
            herdService.save(herd);
        }catch (Exception e){
            errorLog.error("Lỗi tại vị trí editHerd" + e.getMessage());
        }
    }

    @DeleteMapping("/deleteHerd")
    public void deleteHerd(@PathVariable int[] ids){
        try {
            herdService.delete(ids);
        }catch (Exception e){
            errorLog.error("lỗi tại deleteHerd" + e.getMessage());
        }
    }
}
