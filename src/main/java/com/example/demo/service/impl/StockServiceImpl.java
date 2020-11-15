// creator: Tuong

package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.model.Stock$;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Stock;
import com.example.demo.model.StockDTO;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    StockRepository stockRepository;

    // lay ve mot danh sach stock
    @Override
    public List<Stock> getAll() {
        return null;
    }

    @Override
    public Optional<Stock> getById(int id) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        return jpaStreamer.stream(Stock.class).filter(e-> e.getId() == id).findFirst();
    }

    // luu mot stock
    @Override
    public int save(Stock stock) {
        try {
            stockRepository.save(stock);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    // xoa mot list stock boi array id
    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(e ->
            {
                Stock a = jpaStreamer.stream(Stock.class).filter(f -> f.getId() == e).findFirst().get();
                a.setIsDeleted(1);
                stockRepository.save(a);

            });
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<StockDTO> search(int pageNumber, int pageSize,  String search) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<StockDTO> stockDTOList = new ArrayList<>();
        try {
            if(pageNumber==-1){
                        jpaStreamer.stream(Stock.class).filter(e ->
                                e.getIsDeleted()==0 &&
                                        (e.getShipmentCode().contains(search) ||
                                                e.getFeedType().getName().contains(search) || e.getVendor().getName().contains(search)
                                                || e.getExpDate().toString().contains(search) || String.valueOf(e.getQuantity()).contains(search)
                                                || e.getUnit().contains(search))).sorted(Stock$.id.reversed()).forEach(e -> {
                    StockDTO stockDTO = new StockDTO(e.getId(),e.getShipmentCode(), e.getFeedType().getName(),
                            e.getVendor().getName(),e.getMfgDate(), e.getExpDate(), e.getQuantity(), e.getUnit(), e.getImportDate());
                    stockDTOList.add(stockDTO);
                });
                return stockDTOList;
            }
            jpaStreamer.stream(Stock.class).filter(e ->
                    e.getIsDeleted()==0 &&
                            (e.getShipmentCode().contains(search) ||
                                    e.getFeedType().getName().contains(search) || e.getVendor().getName().contains(search)
                                    || e.getExpDate().toString().contains(search) || String.valueOf(e.getQuantity()).contains(search)
                                    || e.getUnit().contains(search))).sorted(Stock$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                StockDTO stockDTO = new StockDTO(e.getId(),e.getShipmentCode(), e.getFeedType().getName(),
                        e.getVendor().getName(),e.getMfgDate(), e.getExpDate(), e.getQuantity(), e.getUnit(), e.getImportDate());
                stockDTOList.add(stockDTO);
            });
            return stockDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jpaStreamer.close();
        }
        return null;
    }

}
