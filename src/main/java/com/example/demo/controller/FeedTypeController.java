package com.example.demo.controller;


import com.example.demo.model.FeedType;
import com.example.demo.service.FeedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedTypeController {
    @Autowired
    private FeedTypeService feedTypeService;


    //Creator Tuong
    @GetMapping("feedType")
    public List<FeedType> getAllFeedType(){
        try {
            return feedTypeService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
