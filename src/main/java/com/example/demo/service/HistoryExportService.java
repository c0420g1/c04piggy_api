package com.example.demo.service;

import com.example.demo.model.HistoryExport;
import com.example.demo.model.HistoryExportDTO;

import java.util.List;

public interface HistoryExportService extends BaseService<HistoryExport> {
    List<HistoryExportDTO> getAllDTO(int pageNum, String search);
}
