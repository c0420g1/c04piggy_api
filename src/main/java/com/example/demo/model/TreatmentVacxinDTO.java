package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class TreatmentVacxinDTO {
    private LocalDate treatDate;
    private String coteCode;
    private String pigCode;
    private String veterinarian;
    private String diseases;
    private String vacxin;
}
