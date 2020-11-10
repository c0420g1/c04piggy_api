package com.example.demo.service;

import com.example.demo.model.Cote;
import com.example.demo.model.CoteDTO;

import java.util.List;

public interface CoteService extends BaseService<Cote> {
    List<CoteDTO> search(int pageNumber, String search);
}
