package com.example.demo.controller;


import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController {
    @Autowired
    private VendorService vendorService;

    // creator Tuong
    @GetMapping("vendor")
    public List<Vendor> getAllVendor(){
        try {
            return vendorService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
