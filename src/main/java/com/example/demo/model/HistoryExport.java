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
public class HistoryExport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    private String type;
    private int quantity;
    private String unit;
    private String company;
    @Column(name = "received_employee_id", columnDefinition = "integer default 0")
    private int receivedEmployeeId = 0;

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

    @Override
    public String toString() {
        return "HistoryExport{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", company='" + company + '\'' +
                ", receivedEmployeeId=" + receivedEmployeeId +
                ", exportDate=" + exportDate +
                ", stock=" + stock +
                ", cote=" + cote +
                ", employee=" + employee +
                '}';
    }
}
