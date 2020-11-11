package com.example.demo.service;

import com.example.demo.model.TreatmentVacxin;
import com.example.demo.model.TreatmentVacxinDTO;

import java.util.List;

public interface TreamentVacxinService extends BaseService<TreatmentVacxin>{
    List<TreatmentVacxinDTO> search(int pageNumber, String search);
}
