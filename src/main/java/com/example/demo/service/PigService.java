package com.example.demo.service;

import com.example.demo.model.Pig;
import com.example.demo.model.PigDTO;

import java.util.List;

public interface PigService extends BaseService<Pig> {
    List<PigDTO> listPigSearch(int pageNumber, String search);
    List<Pig> pickFemalePig(String filter);
    List<Pig> pickMalePig(String filter);
    void saveNewPig(Pig pig);
    void soldPig(int id);
}
