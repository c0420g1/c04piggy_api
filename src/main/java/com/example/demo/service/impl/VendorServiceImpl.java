package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {
    @Override
    public List<Vendor> getAll(int pageNum) {
        return null;
    }

    @Override
    public Optional<Vendor> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Vendor vendor) {

    }

    @Override
    public void delete(int[] ids) {

    }
}
