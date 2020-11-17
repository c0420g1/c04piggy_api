package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;

public interface TreamentVacxinService extends BaseService<TreatmentVacxin>{
    List<TreatmentVacxinDTO> search(int pageNumber, String search, String type);
    List<Pig> getListPig(int coteID);
    List<Diseases> getListDiseases();
    List<Vacxin> getListVacxin();
}
