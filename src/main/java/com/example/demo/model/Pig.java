package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "pig")
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    private String code;
    private String spec;
    private byte gender;
    private double weight;
    private String color;
    @Column(columnDefinition = "integer", name = "father_id")
    private Integer fatherId;
    @Column(columnDefinition = "integer", name = "mother_id")
    private Integer motherId;
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

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", description='" + description + '\'' +
                ", code='" + code +
                ", spec='" + spec +
                ", gender=" + gender +
                ", weight=" + weight +
                ", color=" + color +
                ", fatherId=" + fatherId +
                ", motherId=" + motherId +
                ", importDate=" + importDate +
                ", exportDate=" + exportDate +
                ", feed=" + feed +
                ", herd=" + herd +
                ", cote=" + cote +
                '}';
    }
}
