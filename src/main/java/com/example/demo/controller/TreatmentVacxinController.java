package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.TreatmentVacxin;
import com.example.demo.model.TreatmentVacxinDTO;
import com.example.demo.service.TreamentVacxinService;


import java.util.List;

@RestController
public class TreatmentVacxinController {
    @Autowired
    TreamentVacxinService treamentVacxinService;

    @GetMapping("/treatmentVacxin")
    public List<TreatmentVacxin> getAll(){
        return treamentVacxinService.getAll();
    }

    @GetMapping("/treatmentVacxinDTO/{pageNum}")
    public List<TreatmentVacxinDTO> search(@PathVariable int pageNum, @RequestParam(defaultValue = "") String search, @RequestParam String type){
        return treamentVacxinService.search(pageNum,search,type);
    }

    @GetMapping("/treatmentVacxin/{id}")
    public TreatmentVacxin findInformationById(@PathVariable int id){
        return treamentVacxinService.getById(id).orElse(null);
    }

    @PostMapping("/treatmentVacxin")
    public void addInformation(@RequestBody TreatmentVacxin treatmentVacxin){
        treamentVacxinService.save(treatmentVacxin);
    }

    @PatchMapping("/treatmentVacxin")
    public void updateInformation(@RequestBody TreatmentVacxin treatmentVacxin){
        treamentVacxinService.save(treatmentVacxin);
    }

    @DeleteMapping("/treatmentVacxin")
    public void deleteInformation(@RequestBody int[] ids){
        treamentVacxinService.delete(ids);
    }
}
