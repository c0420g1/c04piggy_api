package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cote")
public class Cote extends BaseEntity {
    private String code;
    private String type;
    private int quantity;
    @Column(columnDefinition="DATE")
    private LocalDate importDate;
    @Column(columnDefinition="DATE")
    private LocalDate exportDate;

    @ManyToOne
    @JoinColumn(name = "herd_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Herd herd;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "cote", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<HistoryExport> historyExports;

    @OneToMany(mappedBy = "cote", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<TreatmentVacxin> treatmentVacxins;

}
