package com.example.demo.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor

public class StockDTO {
    private String shipmentCode;
    private String feedTypeName;
    private String vendorName;
    private LocalDate mfgDate;
    private LocalDate expDate;
    private int quantity;
    private String unit;
    private LocalDate importDate;
}
