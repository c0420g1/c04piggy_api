package com.example.demo.service;

import com.example.demo.model.Cote;

import java.util.List;

public interface CoteService  {

    List<Cote> getAll(int pageNum, String search);
    void save(Cote cote);
    Cote findById(int id);
    void deleteById(int id);
}
