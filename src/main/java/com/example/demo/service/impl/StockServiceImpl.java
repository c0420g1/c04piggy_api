// creator: Tuong

package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.model.*;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    // lay ve 1 stock theo id
    @Override
    public Optional<Stock> getById(int id) {
        try {
            JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
            return jpaStreamer.stream(Stock.class).filter(e-> e.getId() == id).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    // lay ve 1 list StockDTO
    @Override
    public List<StockDTO> search(int pageNumber, int pageSize,  String search) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<StockDTO> stockDTOList = new ArrayList<>();
        try {
            if(pageNumber==-1){
                        jpaStreamer.stream(Stock.class).filter(e ->
                                e.getIsDeleted()==0 &&
                                                   (e.getShipmentCode().toLowerCase().contains(search.toLowerCase())
                                                || e.getFeedType().getName().toLowerCase().contains(search.toLowerCase())
                                                || e.getVendor().getName().toLowerCase().contains(search.toLowerCase())
                                                || e.getExpDate().toString().contains(search)
                                                || String.valueOf(e.getQuantity()).contains(search)
                                                || e.getUnit().toLowerCase().contains(search.toLowerCase()))).sorted(Stock$.id.reversed()).forEach(e -> {
                    StockDTO stockDTO = new StockDTO(e.getId(),e.getShipmentCode(), e.getFeedType().getName(),
                            e.getVendor().getName(),e.getMfgDate(), e.getExpDate(), e.getQuantity(), e.getUnit(), e.getImportDate(), e.getDescription(),
                            e.getVendor().getId(), e.getFeedType().getId());
                    stockDTOList.add(stockDTO);
                });
                return stockDTOList;
            }
            jpaStreamer.stream(Stock.class).filter(e ->
                    e.getIsDeleted()==0 &&
                                    (e.getShipmentCode().toLowerCase().contains(search.toLowerCase())
                                    || e.getFeedType().getName().toLowerCase().contains(search.toLowerCase())
                                    || e.getVendor().getName().toLowerCase().contains(search.toLowerCase())
                                    || e.getExpDate().toString().contains(search)
                                    || String.valueOf(e.getQuantity()).contains(search)
                                    || e.getUnit().toLowerCase().contains(search.toLowerCase()))).sorted(Stock$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber-1)*pageSize).limit(pageSize).forEach(e -> {
                StockDTO stockDTO = new StockDTO(e.getId(),e.getShipmentCode(), e.getFeedType().getName(),
                        e.getVendor().getName(),e.getMfgDate(), e.getExpDate(), e.getQuantity(), e.getUnit(), e.getImportDate(), e.getDescription(),
                        e.getVendor().getId(), e.getFeedType().getId());
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

    // them hoac sua 1 record Stock
    @Override
    public void addEditStock(StockDTO stockDTO) {
        try {
            FeedType feedType= jpaStreamer.stream(FeedType.class).filter(FeedType$.id.equal(stockDTO.getFeedTypeId())).findFirst().get();
            Vendor vendor= jpaStreamer.stream(Vendor.class).filter(Vendor$.id.equal(stockDTO.getVendorId())).findFirst().get();

            Stock stock = Stock.builder().id(stockDTO.getId()).description(stockDTO.getDescription()).expDate(stockDTO.getExpDate())
                    .isDeleted(0).importDate(stockDTO.getImportDate()).mfgDate((stockDTO.getMfgDate())).shipmentCode(stockDTO.getShipmentCode()).unit(stockDTO.getUnit())
                    .quantity(stockDTO.getQuantity()).feedType(feedType).vendor(vendor).build();
            stockRepository.save(stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
