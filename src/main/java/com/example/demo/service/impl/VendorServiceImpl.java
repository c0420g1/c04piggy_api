package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    JPAStreamer jpaStreamer;

    // creator: Tuong
    // lay ve list Vendor
    @Override
    public List<Vendor> getAll(){
        List<Vendor> vendorList;
        try {
            vendorList = jpaStreamer.stream(Vendor.class).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Vendor> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Vendor vendor) {
        return 1;
    }

    @Override
    public int delete(int[] ids) {
        return 1;
    }
}
