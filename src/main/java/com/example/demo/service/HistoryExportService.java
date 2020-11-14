package com.example.demo.service;

import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;

import java.util.List;

public interface HistoryExportService extends BaseService<HistoryExport> {
    List<HistoryExportDTO> getAllDTO(int pageNum, String search);
    Iterable<HistoryExportDTO> getDTO(int pageNum, String search);
    List<HistoryExportStockDTO> getHistoryExportStockDTO(int pageNumber, String search);

}
