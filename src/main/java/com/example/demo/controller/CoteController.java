package com.example.demo.controller;

import com.example.demo.model.Cote;
import com.example.demo.service.CoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoteController {
    @Autowired
    CoteService coteService;


    @GetMapping("cote/{pageNum}")
    public List<Cote> getAll(@RequestParam(defaultValue = "") String search,
                             @PathVariable int pageNum){
        List<Cote> coteList = new ArrayList<>();
        try{
            coteList = coteService.getAll(pageNum,search);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
      return coteList;
    }

    @PostMapping("cote")
    public void addNewCote(@RequestBody Cote cote){
        coteService.save(cote);
    }

    @DeleteMapping("cote")
    public void deleteCote(@RequestBody Cote cote){
        coteService.deleteById(cote.getId());
    }

}
