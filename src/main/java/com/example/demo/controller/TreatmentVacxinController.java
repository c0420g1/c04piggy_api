package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.*;

import com.example.demo.service.TreamentVacxinService;




@RestController
public class TreatmentVacxinController {
    @Autowired
    TreamentVacxinService treamentVacxinService;

// duong nhật huy
// get all list treatment type json
    @GetMapping("/treatmentVacxin")
    public List<TreatmentVacxin> getAll(){
        return treamentVacxinService.getAll();
    }

// dương nhật huy
// get all list treatmentDTO type json by pagination and search
    @GetMapping("/treatmentVacxinDTO/{pageNum}")
    public List<TreatmentVacxinDTO> searchfff(@PathVariable int pageNum, @RequestParam(defaultValue = "") String search, @RequestParam String type){
        return treamentVacxinService.search(pageNum,search,type);
    }

// dương nhật huy
// get treatment by id
    @GetMapping("/treatmentVacxin/{id}")
    public TreatmentVacxin findInformationById(@PathVariable int id){
        return treamentVacxinService.getById(id).orElse(null);
    }

// dương nhật huy
// add new treatmnet
    @PostMapping("/treatmentVacxin")
    public void addInformation(@RequestBody TreatmentVacxin treatmentVacxin){
        treamentVacxinService.save(treatmentVacxin);
    }

// dương nhật huy
// edit treatment
    @PatchMapping("/treatmentVacxin")
    public void updateInformation(@RequestBody TreatmentVacxin treatmentVacxin){
        treamentVacxinService.save(treatmentVacxin);
    }

// dương nhật huy
// delete one or more treatment
    @PutMapping("/treatmentVacxin")
    public void deleteInformation(@RequestBody int[] ids){
        treamentVacxinService.delete(ids);
    }

    @GetMapping("/pig/{coteId}")
    public List<Pig> getPigByCOteId(@PathVariable int coteId){
       return treamentVacxinService.getListPig(coteId);
    }

    @GetMapping("/diseases")
    public  List<Diseases> getListDiseases(){
        return treamentVacxinService.getListDiseases();
    }
    @GetMapping("/medicine")
    public List<Vacxin> getListVacxin(){
        return treamentVacxinService.getListVacxin();
    }
}
