package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PigDTO {
    private int pigId;
    private String code;
    private String cote;
    private LocalDate importDate;
    private List status;
    private Double weight;
}
