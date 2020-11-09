package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "history_export")
public class HistoryExport extends BaseEntity {
    private String type;
    private int quantity;
    private String unit;
    private String company;
    private int receivedEmployeeId;

    @Column(columnDefinition="DATE", name = "export_date")
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
