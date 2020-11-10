package com.example.demo.controller;

import com.example.demo.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PigController {
    @Autowired
    PigService pigService;


}
