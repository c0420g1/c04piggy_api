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

    @GetMapping("cote")
    public List<Cote> getAll(){
        List<Cote> coteList;
        coteList = coteService.getAll();
        return coteList;
    }

    //List has Pagination & Search
    @GetMapping("cote/{pageNum}")
    public List<Cote> getAllPagination(@RequestParam(defaultValue = "") String search,
                                       @PathVariable int pageNum){
        List<Cote> coteList;
        coteList = coteService.searchCote(pageNum,search);
        return coteList;
    }

    @PostMapping("cote")
    public void addNewCote(@RequestBody Cote cote){
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
//
//    @GetMapping("/haicotedto/{pageNum}")
//    public List<CoteDTO> getDTO(@PathVariable int pageNum, @RequestParam String search){
//        return coteService.search(pageNum,search);
//    }
}
