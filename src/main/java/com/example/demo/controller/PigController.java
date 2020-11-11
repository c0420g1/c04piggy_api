package com.example.demo.controller;

import com.example.demo.model.Pig;
import com.example.demo.model.PigDTO;
import com.example.demo.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PigController {
    @Autowired
    private PigService pigService;

    @GetMapping("/pigList/{pageNum}")
    public List<PigDTO> getPigList(@PathVariable int pageNum, @RequestParam String search){
        return pigService.listPigSearch(pageNum,search);
    }

    @GetMapping("/pigDetail")
    public Optional<Pig> getPigDetail(@RequestParam int id){
        return pigService.getById(id);
    }

    @PostMapping("/addPig")
    public void addPig(@RequestBody Pig pigAdd){
        pigService.save(pigAdd);
    }
}
