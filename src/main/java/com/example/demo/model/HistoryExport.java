package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "history_export")
public class HistoryExport extends BaseEntity {
    private String type;
    private int quantity;
    private String unit;
    private String company;
    private int receivedEmployeeId;

    @Column(columnDefinition="DATE")
    private LocalDate exportDate;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "cote_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cote cote;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
