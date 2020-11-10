package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "history_export")
public class HistoryExport extends BaseEntity {
    private String type;
    private int quantity;
    private String unit;
    private String company;
    @Column(name = "received_employee_id")
    private int receivedEmployeeId;

    @Column(columnDefinition="DATE", name = "export_date")
    private LocalDate exportDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stock_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Stock stock;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cote_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cote cote;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
