package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Cote;
import com.example.demo.service.CoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StockController {
    @Autowired
    CoteService coteService;
    @GetMapping("/haicote")
    public Cote getById(){
        return coteService.getById(1).orElse(null);
    }
}
