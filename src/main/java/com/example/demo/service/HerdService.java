package com.example.demo.service;

import com.example.demo.model.Herd;

import java.util.List;

public interface HerdService extends BaseService<Herd>{
    List<Herd> getAllHerdList(int pageNumber);
}
