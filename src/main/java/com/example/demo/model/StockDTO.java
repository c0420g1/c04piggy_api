package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

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
