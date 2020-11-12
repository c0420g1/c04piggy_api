package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class CoteDTO {
    private int id;
    private String coteCode;
    private int quantity;
    private String herdName;
    private String employeeName;
    private String importDate;
    private String exportDate;
}
