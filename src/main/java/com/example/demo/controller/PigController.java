package com.example.demo.controller;

import com.example.demo.model.PigDTO;
import com.example.demo.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PigController {
    @Autowired
    private PigService pigService;

    @GetMapping("/pigList/{pageNum}")
    public List<PigDTO> getPigList(@PathVariable int pageNum, @RequestParam String search){
        return pigService.listPigSearch(pageNum,search);
    }
}
