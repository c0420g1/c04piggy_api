package com.example.demo.controller;

import com.example.demo.model.Cote;
import com.example.demo.model.CoteDTO;
import com.example.demo.service.CoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoteController {
    @Autowired
    CoteService coteService;
    @GetMapping("/haicote")
    public Cote getById(){
        return coteService.getById(1).orElse(null);
    }

    @GetMapping("/haicotedto/{pageNum}")
    public List<CoteDTO> getDTO(@PathVariable int pageNum, @RequestParam String search){
        return coteService.search(pageNum,search);
    }
}
