package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class HistoryExportDTO {
    private int id;
    private String coteCode;
    private String employeeCode;
    private String company;
    private LocalDate exportDate;
    private int quantity;
    private int weightTotal;
    private int total;
}
