package com.example.demo.controller;

import com.example.demo.model.Cote;
import com.example.demo.model.CoteDTO;
import com.example.demo.model.Pig;
import com.example.demo.service.CoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoteController {
    @Autowired
    CoteService coteService;


    //List has Pagination & Search
    @GetMapping("/cote/{pageNum}")
    public List<CoteDTO> getAllPagination(@RequestParam(defaultValue = "") String search,
                                       @PathVariable int pageNum){
        List<CoteDTO> coteList;
        coteList = coteService.searchCote(pageNum,search);
        return coteList;
    }

    @GetMapping("/cote")
    public List<Cote> getAllNoPagination(@RequestParam(defaultValue = "") String search){
        List<Cote> coteList;
        coteList = coteService.searchCoteNoPagination(search);
        return coteList;
    }

    @PostMapping("cote")
    public void addNewCote(@RequestBody Cote cote){
        System.out.println(cote.toString());
        coteService.save(cote);
    }

    @GetMapping("listPig")
    public List<Pig> getAllPig(@RequestParam String herdCode){
        List<Pig> pigList = new ArrayList<>();
        pigList = coteService.getAllPig(herdCode);
        return pigList;
    }

    @GetMapping("idCote/{id}")
    public Cote getById(@PathVariable int id){
        Cote cote;
        cote = coteService.getById(id).orElse(null);
        return cote;
    }
}
