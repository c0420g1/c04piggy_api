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
@Table(name = "treatment_vacxin")
public class TreatmentVacxin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    private String veterinary;
    private String type;
    @Column(columnDefinition="DATE", name= "treat_date")
    private LocalDate treatDate;

    @ManyToOne
    @JoinColumn(name = "cote_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cote cote;

    @ManyToOne
    @JoinColumn(name = "pig_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pig pig;

    @ManyToOne
    @JoinColumn(name = "vacxin_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Vacxin vacxin;

    @ManyToOne
    @JoinColumn(name = "diseases_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Diseases diseases;

}
