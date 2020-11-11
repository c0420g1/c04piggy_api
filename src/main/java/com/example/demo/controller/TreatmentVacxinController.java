package com.example.demo.controller;

import com.example.demo.model.TreatmentVacxin;
import com.example.demo.model.TreatmentVacxinDTO;
import com.example.demo.service.TreamentVacxinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<TreatmentVacxinDTO> search(@PathVariable int pageNum, @RequestParam(defaultValue = "") String search){
        return treamentVacxinService.search(pageNum,search);
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
}
