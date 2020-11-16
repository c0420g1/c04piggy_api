package com.example.demo.controller;

import com.example.demo.model.PigAssociateStatus;
import com.example.demo.model.PigStatus;
import com.example.demo.service.PigAssociateStatusService;
import com.example.demo.service.PigStatusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {
    private static final Log errorLog = LogFactory.getLog(StatusController.class);

    @Autowired
    private PigStatusService pigStatusService;

    @Autowired
    private PigAssociateStatusService pigAssociateStatusService;

    @GetMapping("/pigStatusList")
    public List<PigStatus> getPigStatusList(){
        try {
            return pigStatusService.getAll();
        }catch (Exception e){
            errorLog.error("lỗi tại pigStatusListController" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/pigAssociateStatusListFull")
    public List<PigAssociateStatus> getPigAssociateStatusList(){
        try {
            return pigAssociateStatusService.getAll();
        }catch (Exception e){
            errorLog.error("lỗi tại PigAssociateStatusListController" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/pigAssociateStatusListByPigId")
    public List<PigAssociateStatus> getPigAssociateStatusListByPigId(@PathVariable int id){
        try {
            return pigAssociateStatusService.getAllByPigId(id);
        }catch (Exception e){
            errorLog.error("lỗi tại PigAssociateStatusListByPigId" + e.getMessage());
            return null;
        }
    }

    @PostMapping("/addPigAssociateStatus")
    public void addPigAssociateStatus(@RequestBody PigAssociateStatus pigAssociateStatus) {
        try {
            pigAssociateStatusService.save(pigAssociateStatus);
        }catch (Exception e){
            errorLog.error("lỗi tại vị trí addPigAssociateStatus" + e.getMessage());
        }
    }

    @PatchMapping("/editPigAssociateStatus")
    public void editPigAssociateStatus(@RequestBody PigAssociateStatus pigAssociateStatus) {
        try {
            pigAssociateStatusService.save(pigAssociateStatus);
        }catch (Exception e){
            errorLog.error("Lỗi tại vị trí editPigAssociateStatus" + e.getMessage());
        }
    }

    @DeleteMapping("/deletePigAssociateStatus")
    public void deletePigAssociateStatus(@PathVariable int[] ids){
        try {
            pigAssociateStatusService.delete(ids);
        }catch (Exception e){
            errorLog.error("lỗi tại deletePigAssociateStatus" + e.getMessage());
        }
    }

}
