package com.example.demo.service;

import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;
import com.example.demo.model.HistoryExportStockDTO;

import java.util.List;

public interface HistoryExportService extends BaseService<HistoryExport> {
    List<HistoryExportDTO> search(int pageNum, String search);
    List<HistoryExportDTO> getAllDTO();
    List<HistoryExportStockDTO> getHistoryExportStockDTO(int pageNumber, String search);
}
