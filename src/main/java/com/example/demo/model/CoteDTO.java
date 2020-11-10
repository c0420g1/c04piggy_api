package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CoteDTO {
    private int cote;
    private int quantity;
    private String herdName;
    private String employeeName;
}
