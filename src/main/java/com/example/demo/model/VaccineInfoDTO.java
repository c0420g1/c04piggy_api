package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class VaccineInfoDTO {
    private int id;
    private LocalDate treatDate;
    private String coteCode;
    private String veterinarian;
    private String diseases;
}
