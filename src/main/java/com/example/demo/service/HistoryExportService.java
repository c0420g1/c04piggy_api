package com.example.demo.service;

import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportStockDTO;


import java.util.List;

public interface HistoryExportService extends BaseService<HistoryExport> {
    List<HistoryExportStockDTO> getHistoryExportStockDTO(int pageNumber, String search);
}
