package com.example.demo.controller;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.service.CoteService;
import com.example.demo.service.PigService;


@RestController
public class CoteController {
    @Autowired
    CoteService coteService;

    @Autowired
    PigService pigService;
    // Danh sách chuồng heo có phân trang và search
    @GetMapping("/cote/{pageNum}")
    public List<CoteDTO> getAllPagination(@RequestParam(defaultValue = "") String search,
                                       @PathVariable int pageNum){
        List<CoteDTO> coteList = new ArrayList<>();
        try{
            coteList = coteService.searchCote(pageNum,search);
        } catch (Exception e){
            System.out.println("Get Cote List Controller + "+ e.getMessage());
        }
        return coteList;
    }

    // Trả về số lượng chuồng heo
    @GetMapping("/cote")
    public List<Cote> getAllNoPagination(@RequestParam(defaultValue = "") String search){
        List<Cote> coteList = new ArrayList<>();
        try{
            coteList = coteService.searchCoteNoPagination(search);
        }catch (Exception e){
            System.out.println("Get Size Cote List + "+ e.getMessage());
        }
        return coteList;
    }


    // Thêm 1 chuồng mới
    @PostMapping("cote")
    public void addNewCote(@RequestBody Cote cote){
        try{
            coteService.save(cote);
        }catch (Exception e){
            System.out.println("Save cote + "+ e.getMessage());
        }
    }

    // Trả về danh sách heo có cùng mã đàn
    @GetMapping("listPig")
    public List<Pig> getAllPig(@RequestParam String herdCode){
        List<Pig> pigList = new ArrayList<>();
        try{
            pigList = coteService.getAllPig(herdCode);
        }catch (Exception e){
            System.out.println("List Pig has a same herd + " + e.getMessage());
        }
        return pigList;
    }

    // Trả về danh sách heo DTO
    @GetMapping("listPigStatus")
    public List<PigDTO> getAllStatusPig(@RequestParam String herdCode){
        List<PigDTO> pigList = new ArrayList<>();
        try{
            pigList = coteService.getAllPigDTOAndStatus(herdCode);
        }catch (Exception e){
            System.out.println("List Pig has a same herd + " + e.getMessage());
        }
        return pigList;
    }

    // Trả về thông tin của 1 chuồng
    @GetMapping("idCote/{id}")
    public Cote getById(@PathVariable int id){
        Cote cote = new Cote();
        try{
            cote = coteService.getById(id).orElse(null);
        }catch (Exception e){
            System.out.println("Get Cote by Id + "+ e.getMessage());
        }
        return cote;
    }

    // Trả về danh sách chuồng có số lượng = 0
    @GetMapping("/listCoteCode")
    public List<String> getAllCoteCode(){
        List<String> coteCodeList = new ArrayList<>();
        try {
            coteCodeList = coteService.getCoteCode();
        }catch (Exception e){
            System.out.println("Controller + Get Cote Code + "+ e.getMessage());
        }
        return coteCodeList;
    }

    // Trả về danh sách tên đàn
    @GetMapping("/herdList")
    public List<Herd> getAllHerdName(){
        List<Herd> herdList = new ArrayList<>();
        try {
            herdList = coteService.getListHerd();
        }catch (Exception e){
            System.out.println("Get List Herd  + " + e.getMessage());
        }
        return herdList;
    }
}
