package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Builder
@Data
@Entity
@Table(name = "pig")
public class Pig extends BaseEntity {
    private String code;
    private String spec;
    private byte gender;
    private double weight;
    private String color;
    private int fatherId;
    private int motherId;
    @Column(columnDefinition="DATE")
    private LocalDate importDate;
    @Column(columnDefinition="DATE")
    private LocalDate exportDate;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Feed feed;

    @ManyToOne
    @JoinColumn(name = "cote_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cote cote;

    @ManyToOne
    @JoinColumn(name = "herd_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Herd herd;

    @OneToMany(mappedBy = "pig", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<PigAssociateStatus> pigAssociateStatuses;

    @OneToMany(mappedBy = "pig", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<TreatmentVacxin> treatmentVacxins;
}
