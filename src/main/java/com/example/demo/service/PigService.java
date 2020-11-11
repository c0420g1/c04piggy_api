package com.example.demo.service;

import com.example.demo.model.Pig;
import com.example.demo.model.PigDTO;

import java.util.List;

public interface PigService extends BaseService<Pig> {
    List<PigDTO> listPigSearch(int pageNumber, String search);
}
