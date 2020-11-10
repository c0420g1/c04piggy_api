package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "pig_associate_status")
public class PigAssociateStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "pig_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pig pig;

    @ManyToOne
    @JoinColumn(name = "pig_status_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PigStatus pigStatus;
}
