package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "pig")
public class Pig extends BaseEntity {
    private String code;
    private String spec;
    private byte gender;
    private double weight;
    private String color;
    @Column(columnDefinition = "integer", name = "father_id")
    private int fatherId;
    @Column(columnDefinition = "integer", name = "mother_id")
    private int motherId;
    @Column(columnDefinition="DATE", name = "import_date")
    private LocalDate importDate;
    @Column(columnDefinition="DATE", name = "export_date")
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

    @OneToMany(mappedBy = "pig")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<PigAssociateStatus> pigAssociateStatuses;

    @OneToMany(mappedBy = "pig")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<TreatmentVacxin> treatmentVacxins;
}
