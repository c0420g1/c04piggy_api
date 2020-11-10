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
@Table(name = "treatment_vacxin")
public class TreatmentVacxin extends BaseEntity {
    private String veterinary;
    private String type;
    @Column(columnDefinition="DATE", name="treat_date")
    private LocalDate treatDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cote_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cote cote;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pig_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pig pig;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vacxin_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Vacxin vacxin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "diseases_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Diseases diseases;

}
