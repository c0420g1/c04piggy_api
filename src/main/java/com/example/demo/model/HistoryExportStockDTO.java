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
    private String type;
    private String shipmentCode;
    private String feedTypeName;
    private String vendorName;
    private LocalDate exportDate;
    private int quantityExport;
    private String unit;
    private String exportEmployeeName;
    private String receiveEmployeeName;
}


