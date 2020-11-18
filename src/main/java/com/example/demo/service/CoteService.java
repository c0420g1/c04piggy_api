package com.example.demo.service;
import java.util.List;

import com.example.demo.model.*;


public interface CoteService extends BaseService<Cote> {
    List<CoteDTO> searchCote(int pageNum, String search);
    List<Cote> searchCoteNoPagination(String search);
    List<Pig> getAllPig(String herdCode);
    List<PigDTO> getAllPigDTOAndStatus(String herdCode);
    List<String> getCoteCode();
    List<Herd> getListHerd();
    //creator Hieu
    List<Pig> getAllPigSold();

}
