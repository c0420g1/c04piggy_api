package com.example.demo.service;

import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;
import com.example.demo.model.StockDTO;

import java.util.List;

public interface HistoryExportService extends BaseService<HistoryExport> {
    List<HistoryExportDTO> getAllDTO(int pageNum, String search);
    List<HistoryExportStockDTO> getAllHistoryStockDTO(int pageNumber, int pageSize, String search);
}
