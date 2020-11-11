package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class HistoryExportStockDTO {
    private int id;
    private String shipmentCode;
    private String feedType;
    private String vendor;
    private LocalDate exportDate;
    private int quantity;
    private String unit;
    private String exportEmployee;
    private String receiveEmployee;
}
