package com.example.demo.service;

import com.example.demo.model.Cote;
import com.example.demo.model.CoteDTO;
import com.example.demo.model.Pig;
import com.example.demo.model.PigDTO;

import java.util.List;

public interface CoteService extends BaseService<Cote> {
//    List<CoteDTO> search(int pageNumber, String search);
    List<CoteDTO> searchCote(int pageNum, String search);
    List<Cote> searchCoteNoPagination(String search);
    List<Pig> getAllPig(String herdCode);
//    List<Integer> getAllStatusOfPig(int pigId);
    List<PigDTO> getAllPigDTOAndStatus(String herdCode);


    //creator Hieu
    List<Pig> getAllPigSold();

}
